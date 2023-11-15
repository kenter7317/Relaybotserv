package per.kenter.relaybotserv.repository.users;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import per.kenter.relaybotserv.repository.account.AccountsSNS;
import per.kenter.relaybotserv.repository.account.OauthAccount;

import java.util.List;
import java.util.Map;

@Entity
@Data
@Builder
@AllArgsConstructor
public class LinkedUser {

    @Id
    private Long id;

    private String username;

    private String password;

    @OneToMany(mappedBy = "linkedUser")
    private Map<AccountsSNS, OauthAccount> account;

    public LinkedUser(Long id,  String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public LinkedUser() {
        //re dummy commit
    }
}
