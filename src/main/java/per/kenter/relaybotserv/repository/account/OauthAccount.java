package per.kenter.relaybotserv.repository.account;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;


@Data
@Entity
public class OauthAccount {

    @Id
    private String id;

    private String name;

    private String token;

    private AccountsSNS sns;

}
