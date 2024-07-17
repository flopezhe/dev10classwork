package learn.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HtmlController {

    @GetMapping("/home")
    public String home(){
        return "<h1> Hello </h1>";
    }
}
