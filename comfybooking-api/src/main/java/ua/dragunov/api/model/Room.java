package ua.dragunov.api.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.math.BigDecimal;

@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "picture_id")
    private Picture picture;
    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;
    @Column(name = "room_number", nullable = false)
    private int roomNumber;
    @Min(1)
    @Column(nullable = false)
    private int places;
    private BigDecimal price;
}
