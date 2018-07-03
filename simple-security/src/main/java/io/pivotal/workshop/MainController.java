package io.pivotal.workshop;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping("/")
    public String helloSecurity() {
        return "Hello World! - Secured";
    }
}
