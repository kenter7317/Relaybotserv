package per.kenter.relaybotserv.service.io.request.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RequestWebhookData {

    RequestWebhookBodyData body;

    RequestWebhookHeaderData header;
}
