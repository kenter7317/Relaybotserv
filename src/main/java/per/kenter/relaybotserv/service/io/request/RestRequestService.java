package per.kenter.relaybotserv.service.io.request;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;
import per.kenter.relaybotserv.service.io.request.builder.TwitchRequestBuilder;
import per.kenter.relaybotserv.service.io.request.dto.RequestWebhookData;
import per.kenter.relaybotserv.service.io.request.dto.VerificationData;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Objects;

@Service
public class RestRequestService {
    public static HttpResponse<String> requestEventSubForStream(RequestWebhookData dto) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();

        TwitchRequestBuilder builder = new TwitchRequestBuilder();

        HttpRequest request = builder.
                url("https://api.twitch.tv/helix/eventsub/subscriptions").
                AccessToken(dto.getHeader().getClientSecret()).
                ClientId(dto.getHeader().getClientId()).
                Method("POST").
                Body(dto.getBody()).
                build();

       return client.send(request, HttpResponse.BodyHandlers.ofString());
    }

    public static void setValidResponse(HttpServletResponse response) {
        response.setContentType("text/plain");
        response.setStatus(200);
    }

    public static void classifyData(HttpServletResponse response, VerificationData verificationData) throws IOException {
        if (!Objects.equals(verificationData.subscription.status, "enabled")) {
            response.getWriter().write(verificationData.challenge);
        }
    }
}
