package itmo.controllers;

import itmo.model.Playlist;
import itmo.services.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
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
}
