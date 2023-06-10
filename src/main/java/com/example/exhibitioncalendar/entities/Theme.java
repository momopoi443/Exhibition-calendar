package com.example.exhibitioncalendar.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Entity
@Table(name = "themes")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Theme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "theme_id", nullable = false)
    private Long id;

    @Column(name = "theme_name", nullable = false)
    private String themeName;

    @OneToMany(mappedBy = "theme")
    private Set<Exposition> expositions;
}
