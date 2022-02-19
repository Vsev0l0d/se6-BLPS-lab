package itmo.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Data
@Entity
public class Playlist {
    @Id
    @Column
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private int ownerId;

    @ManyToMany
    @JoinTable(name="film_playlist",
            joinColumns=@JoinColumn(name="playlistId"),
            inverseJoinColumns=@JoinColumn(name="filmId"))
    private Collection<Film> films;
}
