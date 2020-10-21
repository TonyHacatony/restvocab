package heroku.controller;

import heroku.domain.Word;
import heroku.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class WordController {

    @Autowired
    private WordService wordService;

    @GetMapping
    public Collection<Word> getAll() {
        return wordService.getAll();
    }

    @PostMapping("/add")
    public Word add(@RequestParam(value = "name", defaultValue = "empty") String name) {
        return wordService.add(name);
    }

    @GetMapping("/find")
    public Word findById(@RequestParam(value = "id") Long id) {
        return wordService.findById(id).orElse(null);
    }

    @DeleteMapping("/remove")
    public void remove(@RequestParam(value = "id") Long id) {
        wordService.remove(id);
    }
}
