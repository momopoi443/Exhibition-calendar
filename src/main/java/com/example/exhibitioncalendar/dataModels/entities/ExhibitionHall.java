package com.example.exhibitioncalendar.dataModels.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Table(name = "halls")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExhibitionHall {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hall_id", nullable = false)
    private Long id;

    @Column(name = "hall_name", nullable = false)
    private String hallName;

    @OneToMany(mappedBy = "hall")
    private List<Exposition> expositions;
}
