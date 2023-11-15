package per.kenter.relaybotserv.service;

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

}
