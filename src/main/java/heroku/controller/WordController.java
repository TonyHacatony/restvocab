package heroku.controller;

import heroku.domain.Word;
import heroku.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/add")
    public Word add(@RequestParam(value = "name", defaultValue = "empty") String name) {
        return wordService.add(name);
    }
}
