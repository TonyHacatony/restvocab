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

    private final Collection<Word> words = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong();

    @GetMapping
    public Collection<Word> getAll() {
        return wordService.getAll();
    }

    @GetMapping("/add")
    public Word add(@RequestParam(value = "name", defaultValue = "empty") String name) {
        Word word = new Word(counter.incrementAndGet(), name);
        words.add(word);
        return word;
    }
}
