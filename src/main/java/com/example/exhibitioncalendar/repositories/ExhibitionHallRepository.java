package com.example.exhibitioncalendar.repositories;

import com.example.exhibitioncalendar.dataModels.entities.ExhibitionHall;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExhibitionHallRepository extends JpaRepository<ExhibitionHall, Long> {
}
