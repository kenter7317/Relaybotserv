package per.kenter.relaybotserv.service.io.request.builder;

import java.net.URI;
import java.net.http.HttpRequest;
import java.util.Map;

public class RequestBuilderImpl<T extends RequestBuilder<T>> implements RequestBuilder<T> {

    private String url;

    private Map<String, String> headers;

    private String body;

    private String method;

    public HttpRequest build() {
        return HttpRequest.newBuilder()
                .uri(URI.create(url))
                .method(method, HttpRequest.BodyPublishers.ofString(body))
                .headers(String.valueOf(headers))
                .build();
    }

    @Override
    public RequestBuilderImpl url(String url) {

        this.url = url;
        return this;
    }

    @Override
    public RequestBuilderImpl Body(Object dto) {
        body = (String) dto;
        return this;
    }

    @Override
    public RequestBuilderImpl Method(String method) {
        this.method = method;
        return this;
    }

    @Override
    public RequestBuilderImpl Header(String key, String value) {
        headers.put(key, value);
        return this;
    }
}
