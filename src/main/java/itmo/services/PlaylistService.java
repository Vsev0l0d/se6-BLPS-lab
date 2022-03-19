package itmo.services;

import itmo.exceptions.BadRequestException;
import itmo.model.Film;
import itmo.model.Playlist;
import itmo.repositories.PlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaylistService {
    private final PlaylistRepository playlistRepository;
    private final FilmService filmService;

    @Autowired
    public PlaylistService(PlaylistRepository playlistRepository, FilmService filmService) {
        this.playlistRepository = playlistRepository;
        this.filmService = filmService;
    }

    public List<Playlist> getPlayListsByOwnerId(Long ownerId){
        return playlistRepository.findAllByOwnerId(ownerId);
    }

    public void addFilm(Long playlistId, Long filmId){
        Playlist playlist = getPlaylist(playlistId);
        Film film = filmService.getFilm(filmId);

        if (playlist.getFilms().add(film)){
            playlistRepository.save(playlist);
        } else {
            throw new BadRequestException("The film is already in the playlist");
        }
    }

    public void importPlaylist(Long playlistId, Long importedPlaylistId){
        Playlist playlist = getPlaylist(playlistId);
        Playlist importedPlaylist = getPlaylist(importedPlaylistId);

        if(playlist.getFilms().addAll(importedPlaylist.getFilms())){
            playlistRepository.save(playlist);
            importedPlaylist.setCountTimesImported(importedPlaylist.getCountTimesImported() + 1);
            playlistRepository.save(importedPlaylist);
        }
    }

    public void deleteFilm(Long playlistId, Long filmId){
        Playlist playlist = getPlaylist(playlistId);
        Film film = filmService.getFilm(filmId);

        if (playlist.getFilms().remove(film)){
            playlistRepository.save(playlist);
        } else {
            throw new BadRequestException("The film is not in the playlist");
        }
    }

    public Playlist getPlaylist(Long playlistId){
        return playlistRepository.findById(playlistId).orElseThrow(
                () -> new BadRequestException("The playlist doesn't exist")
        );
    }
}
