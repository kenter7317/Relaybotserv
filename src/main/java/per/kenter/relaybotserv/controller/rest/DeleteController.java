package per.kenter.relaybotserv.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import per.kenter.relaybotserv.service.user.UserService;

@RestController
@RequestMapping("/api")
public class DeleteController {
    UserService userService;
    @DeleteMapping("/ad/delete/user/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
    }
}
