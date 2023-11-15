package per.kenter.relaybotserv.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import per.kenter.relaybotserv.repository.LinkedUserRepository;
import per.kenter.relaybotserv.repository.users.LinkedUser;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {

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


}
