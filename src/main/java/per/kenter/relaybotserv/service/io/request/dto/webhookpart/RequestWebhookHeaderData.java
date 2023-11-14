package per.kenter.relaybotserv.service.io.request.dto.webhookpart;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class RequestWebhookHeaderData {
    @JsonProperty("ClientId")
    private String clientId;

}
