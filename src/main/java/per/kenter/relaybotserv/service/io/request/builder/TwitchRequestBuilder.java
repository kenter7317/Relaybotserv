package per.kenter.relaybotserv.service.io.request.builder;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import per.kenter.relaybotserv.service.io.request.dto.RequestWebhookBodyData;

import java.net.URI;
import java.net.http.HttpRequest;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
public class TwitchRequestBuilder {

    private String url;

    private Map<String, String> headers;

    private String body;

    private String method;

    public TwitchRequestBuilder url(String url) {
        this.url = url;
        return this;
    }
    public TwitchRequestBuilder ClientId(String clientId) {
        headers.put("Client-ID", clientId);
        return this;
    }

    public TwitchRequestBuilder AccessToken(String accessToken) {
        headers.put("Authorization", "Bearer " + accessToken);
        return this;
    }

    public TwitchRequestBuilder Body(RequestWebhookBodyData dto) {
        body = dto.toString();
        return this;
    }

    public TwitchRequestBuilder Method(String method) {
        this.method = method;
        return this;
    }

    public HttpRequest build() {
        return HttpRequest.newBuilder()
                .uri(URI.create(url))
                .method(method, HttpRequest.BodyPublishers.ofString(body))
                .headers(String.valueOf(headers))
                .build();
    }
}
