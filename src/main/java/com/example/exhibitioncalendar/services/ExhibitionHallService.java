package com.example.exhibitioncalendar.services;

import com.example.exhibitioncalendar.entities.ExhibitionHall;

import java.util.List;

public interface ExhibitionHallService {

    List<ExhibitionHall> listExhibitionHalls();

    ExhibitionHall getHallById(Long id);
}
