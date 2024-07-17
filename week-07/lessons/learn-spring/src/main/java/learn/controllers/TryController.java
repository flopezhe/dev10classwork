package learn.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TryController {

    @GetMapping
    public String sayHi(){
        return "Hi";
    }

    @GetMapping("/test")
    public String getTest(){
        return "TEST";
    }

}
