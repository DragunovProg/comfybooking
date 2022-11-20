package ua.dragunov.api.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "check_in", nullable = false)
    private Instant checkIn;
    @Column(name = "check_out", nullable = false)
    private Instant checkOut;
    @Column(name = "full_price", nullable = false)
    private BigDecimal fullPrice;
    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false)
    private Room room;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
