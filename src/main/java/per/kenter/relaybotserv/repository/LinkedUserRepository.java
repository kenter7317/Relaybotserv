package per.kenter.relaybotserv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import per.kenter.relaybotserv.repository.users.LinkedUser;

import java.util.List;
import java.util.Optional;

public interface LinkedUserRepository extends JpaRepository<LinkedUser, Long>
{
    Optional<LinkedUser> findById(Long id);
    @Override
    List<LinkedUser> findAll();
}
