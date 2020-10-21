package heroku.service;

import heroku.domain.Word;
import heroku.repository.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class WordService {

    @Autowired
    private WordRepository repository;

    public Collection<Word> getAll(){
        return (Collection<Word>) repository.findAll();
    }
}
