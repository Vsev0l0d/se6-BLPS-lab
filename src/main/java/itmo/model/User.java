package itmo.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "accounts")
public class User {
    @Id
    @Column
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column
    private String username;

    @Column
    private String mail;
}