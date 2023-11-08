package per.kenter.relaybotserv.controller.rest;


import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.*;
import per.kenter.relaybotserv.service.io.request.dto.RequestWebhookData;
import per.kenter.relaybotserv.service.io.request.dto.VerificationData;
import per.kenter.relaybotserv.service.io.response.RestResponseService;

import java.io.IOException;



import static per.kenter.relaybotserv.service.io.request.RestRequestService.*;

@RestController
@RequestMapping("/api/post")
public class PostController {


    @PostMapping("/callback")
    public void callback(HttpServletResponse response, @RequestBody VerificationData verificationData) throws IOException {
        RestResponseService.setValidResponse(response);
        RestResponseService.classifyData(response, verificationData);
    }

    @PostMapping("/ad/getUsers")
    public void getUsers(HttpServletResponse response) throws IOException {
        RestResponseService.setValidResponse(response);
    }

    @PostMapping("/ad/getOAuthAC")
    public void getOAuthAC(HttpServletResponse response) throws IOException {
        RestResponseService.setValidResponse(response);
    }


    @PostMapping("/reqsub")
    public void requestEventSub( HttpServletResponse response, @RequestBody RequestWebhookData REQEventSub) throws IOException, InterruptedException {
        RestResponseService.setValidResponse(response);
        requestEventSubForStream(REQEventSub);
    }
}