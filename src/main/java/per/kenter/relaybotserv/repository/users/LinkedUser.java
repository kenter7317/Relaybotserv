package per.kenter.relaybotserv.repository.users;

import jakarta.persistence.*;
import lombok.*;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import per.kenter.relaybotserv.repository.account.AccountsSNS;
import per.kenter.relaybotserv.repository.account.OauthAccount;
import per.kenter.relaybotserv.repository.users.info.Role;
import per.kenter.relaybotserv.repository.users.info.UserValidState;

import java.util.Collection;
import java.util.Map;

@Entity
@Builder
@Getter
@RequiredArgsConstructor
public class LinkedUser implements UserDetails {

    @Id
    private Long id;

    private String username;

    private String password;

    private Role role;

    private UserValidState state;


    @OneToMany(mappedBy = "linkedUser")
    private Map<AccountsSNS, OauthAccount> account;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return AuthorityUtils.createAuthorityList(role.name());
    }

    @Override
    public boolean isAccountNonExpired() {
        return !state.equals(UserValidState.Expired);
    }

    @Override
    public boolean isAccountNonLocked() {
        return !state.equals(UserValidState.Lock);
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return state.equals(UserValidState.Enabled);
    }
}
