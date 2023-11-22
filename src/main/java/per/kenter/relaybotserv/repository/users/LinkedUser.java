package per.kenter.relaybotserv.repository.users;

import jakarta.persistence.*;
import lombok.*;

import per.kenter.relaybotserv.repository.account.AccountsSNS;
import per.kenter.relaybotserv.repository.account.OauthAccount;

import java.util.Map;

@Entity
@Builder
@Getter
@RequiredArgsConstructor
public class LinkedUser {

    @Id
    private Long id;

    private String username;

    private String password;

    private  Role role;

    @OneToMany(mappedBy = "linkedUser")
    private Map<AccountsSNS, OauthAccount> account;

}
