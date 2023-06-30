package com.example.exhibitioncalendar.services;

import com.example.exhibitioncalendar.entities.Exposition;

import java.util.List;

public interface ExpositionService {

    List<Exposition> getAllExpositionsByHallId(Long hallId);

    List<Exposition> getAllExpositionsByThemeId(Long themeId);

    List<Exposition> getAllExpositionsByHallIdAndThemeId(Long hallId, Long themeId);

    List<Exposition> getAllExpositions();

    Exposition getExpositionById(Long expositionId);
}
