package per.kenter.relaybotserv.service.io.response;

import jakarta.servlet.http.HttpServletResponse;
import per.kenter.relaybotserv.service.io.request.dto.twitch.VerificationData;

import java.io.IOException;
import java.util.Objects;

public class RestResponseService {
    public static void setValidResponse(HttpServletResponse response) {
        response.setContentType("text/plain");
        response.setStatus(200);
    }

    public static void classifyData(HttpServletResponse response, VerificationData verificationData) throws IOException {
        if (!Objects.equals(verificationData.subscription.status, "enabled")) {
            response.getWriter().write(verificationData.challenge);
        }
    }
}
