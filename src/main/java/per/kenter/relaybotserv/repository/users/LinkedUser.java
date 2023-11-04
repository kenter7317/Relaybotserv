package per.kenter.relaybotserv.repository.users;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import per.kenter.relaybotserv.repository.account.OauthAccount;

@Entity
@Data
public class LinkedUser {

    @Id
    private Long id;

    private String username;

    private String password;

    @ManyToOne
    @JoinColumn(name = "AccountID")
    private OauthAccount account;
}
