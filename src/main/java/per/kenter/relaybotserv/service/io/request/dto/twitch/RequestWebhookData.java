package per.kenter.relaybotserv.service.io.request.dto.twitch;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import per.kenter.relaybotserv.service.io.request.dto.twitch.webhookpart.RequestWebhookBodyData;
import per.kenter.relaybotserv.service.io.request.dto.twitch.webhookpart.RequestWebhookHeaderData;

@Getter
@Setter
@AllArgsConstructor
public class RequestWebhookData {

    RequestWebhookBodyData body;

    RequestWebhookHeaderData header;

}
