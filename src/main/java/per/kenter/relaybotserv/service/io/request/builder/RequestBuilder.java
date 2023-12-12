package per.kenter.relaybotserv.service.io.request.builder;

import java.net.http.HttpRequest;

public interface RequestBuilder<T extends  RequestBuilder<T>>{
    T url(String url);
    T Body(Object dto);

    T Method(String method);
    T Header(String key, String value);

    HttpRequest build();
}
