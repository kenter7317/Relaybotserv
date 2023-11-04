package per.kenter.relaybotserv.controller.rest;


import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import per.kenter.relaybotserv.service.io.request.dto.RequestWebhookData;
import per.kenter.relaybotserv.service.io.request.dto.VerificationData;

import java.io.IOException;


import static per.kenter.relaybotserv.service.io.request.RestRequestService.*;

@RestController
@RequestMapping("/api")
public class PostController {


    @PostMapping("/callback")
    public void callback(HttpServletResponse response, @RequestBody VerificationData verificationData) throws IOException {
        setValidResponse(response);
        classifyData(response, verificationData);
    }





    @PostMapping("/reqsub")
    public void requestEventSub(@RequestBody RequestWebhookData REQEventSub) throws IOException, InterruptedException {
        requestEventSubForStream(REQEventSub);
    }
}