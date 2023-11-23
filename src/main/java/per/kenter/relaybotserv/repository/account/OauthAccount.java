package per.kenter.relaybotserv.repository.account;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;
import per.kenter.relaybotserv.repository.users.LinkedUser;

import java.util.Collection;
import java.util.Map;

import static per.kenter.relaybotserv.service.DataProcessUtil.processOAuthAccountsAttribute;


@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class OauthAccount implements OAuth2User {

    @Id
    private String id;

    private String name;

    private String token;

    private AccountsSNS sns;

    @ManyToOne
    private LinkedUser user;

    @Override
    public Map<String, Object> getAttributes() {
        return processOAuthAccountsAttribute(this);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }
}
