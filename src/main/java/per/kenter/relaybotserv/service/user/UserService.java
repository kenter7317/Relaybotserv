package per.kenter.relaybotserv.service.user;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import per.kenter.relaybotserv.repository.LinkedUserRepository;
import per.kenter.relaybotserv.repository.users.LinkedUser;

import java.util.List;
@RequiredArgsConstructor
@Service
public class UserService implements UserDetailsService {
    @Autowired
    private final LinkedUserRepository repository;

    public void updateUser(LinkedUser user) {
        repository.save(user);
    }

    public List<LinkedUser> getUsers() {
        return repository.findAll();
    }

    public LinkedUser getUser(Long id) { return repository.findById(id).orElseThrow();}

    public void deleteUser(Long id) {
        repository.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByUsername(username).orElseThrow();
    }


}
