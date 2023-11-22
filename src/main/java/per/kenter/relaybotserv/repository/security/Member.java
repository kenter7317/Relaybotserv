package per.kenter.relaybotserv.repository.security;

import lombok.Getter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import per.kenter.relaybotserv.repository.users.LinkedUser;

@Getter
public class Member extends User {

    private final LinkedUser user;
    public Member(LinkedUser user) {
        super(user.getUsername(), user.getPassword(), AuthorityUtils.createAuthorityList(user.getRole().toString()));

        this.user = user;
    }
}
