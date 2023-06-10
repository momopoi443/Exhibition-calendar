package com.example.exhibitioncalendar.services;

import com.example.exhibitioncalendar.entities.ExhibitionHall;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ExhibitionHallService {

    List<ExhibitionHall> listExhibitionHalls();

    Optional<ExhibitionHall> getHallById(Long id);
}
