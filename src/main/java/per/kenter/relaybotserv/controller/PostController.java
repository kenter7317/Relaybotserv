package per.kenter.relaybotserv.controller;


import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import per.kenter.relaybotserv.service.io.Req.dto.REQEventSubDTO;
import per.kenter.relaybotserv.service.io.Req.dto.VerificationData;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Objects;

import static per.kenter.relaybotserv.service.io.Req.RestRequestService.requestEventSubForStream;

@RestController
@RequestMapping("/api")
public class PostController {


    @PostMapping("/callback")
    public void callback(HttpServletResponse response, @RequestBody VerificationData verificationData) throws IOException, InterruptedException {
        response.setContentType("text/plain");
        response.setStatus(200);
        if (!Objects.equals(verificationData.subscription.status, "enabled")) {
            response.getWriter().write(verificationData.challenge);
        }
    }

    @PostMapping("/reqsub")
    public void requestEventSub(@RequestBody REQEventSubDTO REQEventSub) throws URISyntaxException, IOException, InterruptedException {
        requestEventSubForStream(REQEventSub);
    }

}