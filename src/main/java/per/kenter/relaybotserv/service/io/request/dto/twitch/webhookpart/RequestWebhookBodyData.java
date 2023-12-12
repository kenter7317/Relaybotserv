package per.kenter.relaybotserv.service.io.request.dto.twitch.webhookpart;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RequestWebhookBodyData {

    private TransportEntity transport;

    private ConditionEntity condition;

    private String version;

    private String type;

    @Getter
    public static class TransportEntity {
        private String callback;
    }

    @Getter
    public static class ConditionEntity {
        private String broadcaster_user_id;
    }

    @JsonProperty("ClientSecret")
    private String clientSecret;

    @Override
    public String toString() {
        return "{\"type\":" + type + "," +
                "\"version\":" + version + "," +
                "\"condition\":{" +
                "\"broadcaster_user_id\":" + condition.getBroadcaster_user_id() + ", \"moderator_user_id\": \"1234\"}," +
                "\"transport\":" +
                "{\"method\":\"webhook\",\"callback\":" + transport.getCallback() + "}}";
    }
}
