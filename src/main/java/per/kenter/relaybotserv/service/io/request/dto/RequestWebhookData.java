package per.kenter.relaybotserv.service.io.request.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import per.kenter.relaybotserv.service.io.request.dto.webhookpart.RequestWebhookBodyData;
import per.kenter.relaybotserv.service.io.request.dto.webhookpart.RequestWebhookHeaderData;

@Getter
@Setter
@AllArgsConstructor
public class RequestWebhookData {

    RequestWebhookBodyData body;

    RequestWebhookHeaderData header;

}
