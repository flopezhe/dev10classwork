package learn.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RestController
public class HodgePodgeController {

    static int sheepCount = 0;

    @GetMapping("/name")
    public String getName(){
        return "Farid Lopez";
    }

    @GetMapping("/current/time")
    public LocalDateTime getCurrentTime(){
        return LocalDateTime.now();
    }

    @GetMapping("/greet/{name}")
    public String getGreeting(@PathVariable String name){
        return String.format("Hello, %s",name);
    }

    @PutMapping("/sheep")
    public void incrementSheep(){
        sheepCount++;
    }

    @GetMapping("/sheep")
    public int getSheepCount(){
        return sheepCount;
    }
}
