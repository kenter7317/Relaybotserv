package per.kenter.relaybotserv.service.io.Req;

import org.springframework.stereotype.Service;
import per.kenter.relaybotserv.service.io.Req.dto.REQEventSubDTO;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
@Service
public class RestRequestService {
    public static HttpResponse<String> requestEventSubForStream(REQEventSubDTO dto) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.twitch.tv/helix/eventsub/subscriptions"))
                .POST(HttpRequest.BodyPublishers.ofString("{\"type\":\"stream.online\",\"version\":\"2\",\"condition\":{\"broadcaster_user_id\":\"" + dto.getUserId() + "\"},\"transport\":{\"method\":\"webhook\",\"callback\":\"https://localhost/callback\",\"secret\":\"s3cre77890ab\"}}"))
                .setHeader("Authorization", "Bearer mvdfipj6grqv34e2nwgme8q6jczhs5")
                .setHeader("Client-Id", "pmp56k7qlzfhra4ibo1brj45aja40h")
                .setHeader("Content-Type", "application/json")
                .build();

       return client.send(request, HttpResponse.BodyHandlers.ofString());
    }
}
