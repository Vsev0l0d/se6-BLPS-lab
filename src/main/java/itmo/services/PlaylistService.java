package itmo.services;

import itmo.model.Playlist;
import itmo.repositories.FilmRepository;
import itmo.repositories.PlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaylistService {
    private final PlaylistRepository playlistRepository;
    private final FilmRepository filmRepository;

    @Autowired
    public PlaylistService(PlaylistRepository playlistRepository, FilmRepository filmRepository) {
        this.playlistRepository = playlistRepository;
        this.filmRepository = filmRepository;
    }

    public List<Playlist> getPlayListsByOwnerId(Long ownerId){
        return playlistRepository.findAllByOwnerId(ownerId);
    }
}
