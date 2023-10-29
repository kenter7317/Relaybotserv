package per.kenter.relaybotserv.service.io.request.builder;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;
import per.kenter.relaybotserv.service.io.request.dto.RequestWebhookBodyData;

import java.net.URI;
import java.net.http.HttpRequest;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TwitchRequestBuilder {

    private String url;

    private Map<String, String> headers;

    private String body;

    private String method;

    public TwitchRequestBuilder url(String url) {
        this.url = url;
        return this;
    }
    public TwitchRequestBuilder setClientId(String clientId) {
        headers.put("Client-ID", clientId);
        return this;
    }

    public TwitchRequestBuilder setAccessToken(String accessToken) {
        headers.put("Authorization", "Bearer " + accessToken);
        return this;
    }

    public TwitchRequestBuilder setBody(RequestWebhookBodyData dto) {
        body = dto.toString();
        return this;
    }

    public TwitchRequestBuilder setMethod(String method) {
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
