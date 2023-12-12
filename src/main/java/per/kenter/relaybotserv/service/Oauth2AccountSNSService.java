package per.kenter.relaybotserv.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import per.kenter.relaybotserv.repository.OauthAccountRepository;
import per.kenter.relaybotserv.repository.account.AccountsSNS;
import per.kenter.relaybotserv.repository.account.OauthAccount;

import java.util.List;

import static per.kenter.relaybotserv.service.DataProcessUtil.getAccountsSNS;

@RequiredArgsConstructor
@Service
public class Oauth2AccountSNSService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {

    private final OauthAccountRepository repository;
    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        AccountsSNS sns = getAccountsSNS(userRequest);
        switch (sns) {
            case Twitch -> {

            }
            case Youtube -> {

            }
            default -> throw new IllegalStateException("Unexpected value: " + getAccountsSNS(userRequest));
        }
        return null;
    }

    public List<OauthAccount> getAccounts()  {
        return  repository.findAll();
    }
}
