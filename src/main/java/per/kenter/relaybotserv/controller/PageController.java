package per.kenter.relaybotserv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {


    @GetMapping("/panel")
    public String panel() {
        return "panel";
    }
}
