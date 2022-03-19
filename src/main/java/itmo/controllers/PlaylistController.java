package itmo.controllers;

import itmo.model.Playlist;
import itmo.services.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlaylistController {
    private final PlaylistService playlistService;

    @Autowired
    public PlaylistController(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }

    @GetMapping("/playlists/{ownerId}")
    public List<Playlist> getPlayListsByOwnerId(@PathVariable Long ownerId){
        return playlistService.getPlayListsByOwnerId(ownerId);
    }

    @PostMapping("/playlist/{playlistId}/film/{filmId}")
    public void addFilm(@PathVariable Long playlistId, @PathVariable Long filmId){
        playlistService.addFilm(playlistId, filmId);
    }

    @PostMapping("/playlist/{playlistId}/import/{importedPlaylistId}")
    public void importPlaylist(@PathVariable Long playlistId, @PathVariable Long importedPlaylistId){
        playlistService.importPlaylist(playlistId, importedPlaylistId);
    }

    @DeleteMapping("/playlist/{playlistId}/film/{filmId}")
    public void deleteFilm(@PathVariable Long playlistId, @PathVariable Long filmId){
        playlistService.deleteFilm(playlistId, filmId);
    }
}
