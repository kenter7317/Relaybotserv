package per.kenter.relaybotserv.service.io.Req.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class REQEventSubDTO {

    @JsonProperty("token")
    private String token;

    @JsonProperty("ClientId")
    private String clientId;

    @JsonProperty("UserId")
    private String userId;
}
