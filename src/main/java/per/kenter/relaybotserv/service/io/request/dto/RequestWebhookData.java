package per.kenter.relaybotserv.service.io.request.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RequestWebhookData {

    @JsonProperty("token")
    private String token;

    @JsonProperty("mission")
    private String mission;

    @JsonProperty("ClientId")
    private String clientId;

    @JsonProperty("UserId")
    private String userId;

}
