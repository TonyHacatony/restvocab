package heroku.controller;

import heroku.domain.Word;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class WordController {

    private Collection<Word> words = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong();

    @GetMapping
    public Collection<Word> getAll() {
        return words;
    }

    @GetMapping("/add")
    public Word add(@RequestParam(value = "name", defaultValue = "empty") String name) {
        Word word = new Word(counter.incrementAndGet(), name);
        words.add(word);
        return word;
    }
}
