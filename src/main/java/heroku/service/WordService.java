package heroku.service;

import heroku.domain.Word;
import heroku.repository.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class WordService {

    @Autowired
    private WordRepository repository;

    public Collection<Word> getAll() {
        return (Collection<Word>) repository.findAll();
    }

    public Optional<Word> findById(long id){
        return repository.findById(id);
    }

    public Word add(String name) {
        return repository.save(new Word(name));
    }

    public void remove(Long id){
        repository.deleteById(id);
    }

    public void remove(String name){
        // TODO implement
    }
}