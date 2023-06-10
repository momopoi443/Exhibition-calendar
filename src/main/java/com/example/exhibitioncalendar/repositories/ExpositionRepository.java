package com.example.exhibitioncalendar.repositories;

import com.example.exhibitioncalendar.entities.ExhibitionHall;
import com.example.exhibitioncalendar.entities.Exposition;
import com.example.exhibitioncalendar.entities.Theme;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpositionRepository extends JpaRepository<Exposition, Long> {

    List<Exposition> findAllByHall(ExhibitionHall hall);

    List<Exposition> findAllByTheme(Theme theme);

    List<Exposition> findAllByHallAndTheme(ExhibitionHall hall, Theme theme);

}
