package per.kenter.relaybotserv.service;

import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import per.kenter.relaybotserv.repository.account.AccountsSNS;
import per.kenter.relaybotserv.repository.account.OauthAccount;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DataProcessUtil {

    public static Map<String,  Object> processOAuthAccountsAttribute(OauthAccount account){
        HashMap<String, Object> attributes = new HashMap<>();
        Arrays.stream(account.getClass().getFields()).forEach(field -> {
            try {
                attributes.put(field.getName(), account.getClass().getField(field.getName()));
            } catch (NoSuchFieldException e) {
                throw new RuntimeException(e);
            }
        });
        return attributes;
    }

    public static AccountsSNS getAccountsSNS(OAuth2UserRequest request){
        return AccountsSNS.valueOf(AccountsSNS.class, request.getClientRegistration().getClientName());
    }


}
