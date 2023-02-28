package springSecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class controllerNew {

    @GetMapping("/")
    public String showCommonRoom () {
        return "commonRoom";
    }

    @GetMapping("/server_Room")
    public String showServerRoom() {
        return "serverRoom";
    }

    @GetMapping("/security_Room")
    public String showSecurityRoom() {
        return "securityRoom";
    }

    @GetMapping("/boss_Office")
    public String showBossOffice() {
        return "bossOffice";
    }
}
