package per.kenter.relaybotserv.service.io.request.builder.builders;

import per.kenter.relaybotserv.service.io.request.builder.RequestBuilder;
import per.kenter.relaybotserv.service.io.request.builder.RequestBuilderImpl;
import per.kenter.relaybotserv.service.io.request.dto.discord.WebhookBody;

import java.net.http.HttpRequest;

public class DiscordRequestBuilder extends RequestBuilderImpl {

    String bodyTemp;

    @Override
    public HttpRequest build() {
        return super.build();
    }

    @Override
    public DiscordRequestBuilder url(String url) {
        return super.url(url);
    }

    @Override
    public DiscordRequestBuilder Body(Object dto) {
        return super.Body(dto);
    }

    @Override
    public DiscordRequestBuilder Method(String method) {
        return super.Method(method);
    }

    @Override
    public DiscordRequestBuilder Header(String key, String value) {
        return null;
    }

    public DiscordRequestBuilder ContentType(String type) {
        return this.Header("Content-Type", type);
    }

    public DiscordRequestBuilder Accept(){
        return this.Header("Accept", "application/json");
    }
    public DiscordRequestBuilder Content(String content){
        bodyTemp =
        return this.Body(content);
    }

    public DiscordRequestBuilder execute() {
        Method("Post").
        return this;
    }
}