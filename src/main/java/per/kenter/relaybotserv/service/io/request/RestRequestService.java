package per.kenter.relaybotserv.service.io.request;

import org.springframework.stereotype.Service;
import per.kenter.relaybotserv.service.io.request.builder.TwitchRequestBuilder;
import per.kenter.relaybotserv.service.io.request.dto.RequestWebhookData;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

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

}
