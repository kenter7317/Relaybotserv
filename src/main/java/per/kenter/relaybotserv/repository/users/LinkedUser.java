package per.kenter.relaybotserv.repository.users;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import per.kenter.relaybotserv.repository.account.OauthAccount;

@Entity
@Data
@Builder
@AllArgsConstructor
public class LinkedUser {

    @Id
    private Long id;

    private String username;

    private String password;

    @ManyToOne
    @JoinColumn(name = "AccountList")
    private OauthAccount account;

    public LinkedUser(Long id,  String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public LinkedUser() {
        //dummy commit
    }
}
