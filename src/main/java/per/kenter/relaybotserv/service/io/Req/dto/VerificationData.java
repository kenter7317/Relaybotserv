package per.kenter.relaybotserv.service.io.Req.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.Nullable;
import lombok.Getter;
@Getter
public class VerificationData {
    private EventEntity event;
    public SubscriptionEntity subscription;
    public String challenge;
    @Getter
    @Nullable
    public static class EventEntity {
        @JsonProperty("started_at")
        private String startedAt;
        @JsonProperty("type")
        private String type;
        @JsonProperty("broadcaster_user_name")
        private String broadcasterUserName;
        @JsonProperty("broadcaster_user_login")
        private String broadcasterUserLogin;
        @JsonProperty("broadcaster_user_id")
        private String broadcasterUserId;
        @JsonProperty("id")
        private String id;
    }
    public static class SubscriptionEntity {

        public String created_at;
        public TransportEntity transport;
        public ConditionEntity condition;
        public int cost;
        public String version;
        public String type;
        public String status;
        public String id;
    }

    public static class TransportEntity {
        public String callback;
        public String method;
    }

    public static class ConditionEntity {
        public String broadcaster_user_id;
    }
}
