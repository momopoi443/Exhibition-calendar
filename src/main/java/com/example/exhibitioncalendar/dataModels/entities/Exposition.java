package com.example.exhibitioncalendar.dataModels.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Entity
@Table(name = "expositions")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Exposition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exposition_id", nullable = false)
    private Long id;

    @Column(name = "exposition_name", nullable = false)
    private String expositionName;

    @Column(name = "ticket_price")
    private Double ticketPrice;

    @ManyToOne//(cascade = CascadeType.ALL)
    @JoinColumn(name = "hall_id", referencedColumnName = "hall_id", nullable = false)
    private ExhibitionHall hall;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "theme_id", nullable = false)
    private Theme theme;

    @OneToMany(mappedBy = "exposition")
    private Set<Ticket> tickets;
}
