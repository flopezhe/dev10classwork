package learn.boardgames.controllers;

import learn.boardgames.models.BoardGameWeight;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/board-game-weight")
public class BoardGameWeightController {

    @GetMapping
    public BoardGameWeight[] findAll() {
        return BoardGameWeight.values();
    }
}
