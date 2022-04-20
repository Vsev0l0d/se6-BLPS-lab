package itmo.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table
public class ImportStat {
    @Id
    @Column
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column
    private String ownerMail;

    @Column
    private String playlistName;

    @Column
    private String importerName;
}
