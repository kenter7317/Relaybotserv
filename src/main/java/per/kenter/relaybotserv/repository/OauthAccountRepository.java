package per.kenter.relaybotserv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import per.kenter.relaybotserv.repository.account.OauthAccount;

import java.util.Optional;

public interface OauthAccountRepository extends JpaRepository<OauthAccount, Long>
{
    Optional<OauthAccount> findById(String oauthId);

    default OauthAccount findOrCreate(String oauthId)
    {
        return findById(oauthId).orElseGet(() -> save(new OauthAccount()));
    }

    default OauthAccount findOrCreate(OauthAccount account)
    {
        return findOrCreate(account.getId());
    }
}
