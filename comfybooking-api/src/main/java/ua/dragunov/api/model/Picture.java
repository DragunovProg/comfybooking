package ua.dragunov.api.model;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class Picture {
    @Id
    @GeneratedValue
    private UUID id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String location;
}
