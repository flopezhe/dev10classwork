package learn.boardgames.controllers;

import learn.boardgames.domain.BoardGameService;
import learn.boardgames.domain.Result;
import learn.boardgames.domain.ResultType;
import learn.boardgames.models.BoardGame;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/board-game")
public class BoardGameController {

    private final BoardGameService service;

    public BoardGameController(BoardGameService service) {
        this.service = service;
    }

    @GetMapping
    public List<BoardGame> findAll() {
        return service.findAll();
    }

    @GetMapping("/players/{numberOfPlayers}")
    public List<BoardGame> findByNumberOfPlayers(@PathVariable int numberOfPlayers) {
        return service.findByNumberOfPlayers(numberOfPlayers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BoardGame> findById(@PathVariable int id) {
        BoardGame game = service.findById(id);
        if (game == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok().body(game);
        }
    }

    @GetMapping("/title")
    public List<BoardGame> findByTitle(@RequestParam String title) {
        return  service.findByTitle(title);
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody BoardGame boardGame) {
        Result<BoardGame> result = service.add(boardGame);
        if (result.isSuccess()) {
            return new ResponseEntity<>(result.getPayload(), HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(result.getMessages(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody BoardGame boardGame) {
        if (id != boardGame.getBoardGameId()) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        Result<BoardGame> result = service.update(boardGame);
        if (result.isSuccess()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else if (result.getResultType() == ResultType.NOT_FOUND) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(result.getMessages(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable int id) {
        Result<Void> result = service.deleteById(id);
        if (result.isSuccess()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else if (result.getResultType() == ResultType.NOT_FOUND) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(result.getMessages(), HttpStatus.BAD_REQUEST);
        }
    }
}
