package itmo.services;

import itmo.model.Film;
import itmo.repositories.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FilmService {
    private final FilmRepository filmRepository;

    @Autowired
    public FilmService(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    public Optional<Film> getFilm(Long id){
        return filmRepository.findById(id);
    }

    public List<Film> findByNameContains(String str){
        return filmRepository.findByNameContains(str);
    }
}
