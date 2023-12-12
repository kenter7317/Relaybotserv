package per.kenter.relaybotserv.controller.rest;


import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.*;
import per.kenter.relaybotserv.repository.account.OauthAccount;
import per.kenter.relaybotserv.repository.users.LinkedUser;
import per.kenter.relaybotserv.service.Oauth2AccountSNSService;
import per.kenter.relaybotserv.service.io.request.dto.twitch.RequestWebhookData;
import per.kenter.relaybotserv.service.io.request.dto.twitch.VerificationData;
import per.kenter.relaybotserv.service.io.response.RestResponseService;
import per.kenter.relaybotserv.service.user.UserService;

import java.io.IOException;
import java.util.List;


import static per.kenter.relaybotserv.service.io.request.RestRequestService.*;

@RestController
@RequestMapping("/api/post")
public class PostController {

    UserService userService;

    Oauth2AccountSNSService oauth2AccountSNSService;

    @PostMapping("/callback")
    public void callback(HttpServletResponse response, @RequestBody VerificationData verificationData) throws IOException {
        RestResponseService.setValidResponse(response);
        RestResponseService.classifyData(response, verificationData);

    }

    @PostMapping("/ad/getUsers")
    public List<LinkedUser> getUsers(HttpServletResponse response) throws IOException {
        RestResponseService.setValidResponse(response);
        return userService.getUsers();
    }

    @PostMapping("/ad/getOAuthAC")
    public List<OauthAccount> getOAuthAC(HttpServletResponse response) throws IOException {
        RestResponseService.setValidResponse(response);
        return oauth2AccountSNSService.getAccounts();
    }


    @PostMapping("/reqsub")
    public String requestEventSub( HttpServletResponse response, @RequestBody RequestWebhookData REQEventSub) throws IOException, InterruptedException {
        RestResponseService.setValidResponse(response);
        requestEventSubForStream(REQEventSub);
        return "complete";
    }
}