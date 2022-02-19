package itmo.repositories;

import itmo.model.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlaylistRepository extends JpaRepository<Playlist, Integer> {
    List<Playlist> findAllByOwnerId(Integer ownerId);
}
