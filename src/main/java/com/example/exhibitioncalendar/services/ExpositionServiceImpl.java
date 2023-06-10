package com.example.exhibitioncalendar.services;

import com.example.exhibitioncalendar.entities.ExhibitionHall;
import com.example.exhibitioncalendar.entities.Exposition;
import com.example.exhibitioncalendar.entities.Theme;
import com.example.exhibitioncalendar.repositories.ExpositionRepository;
import com.example.exhibitioncalendar.services.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ExpositionServiceImpl implements ExpositionService {

    private final ExpositionRepository expositionRepository;
    private final ExhibitionHallService exhibitionHallService;
    private final ThemeService themeService;

    @Override
    public List<Exposition> getAllExpositionsByHallId(Long hallId) {
        ExhibitionHall exhibitionHall = exhibitionHallService
                .getHallById(hallId)
                .orElseThrow(() -> new NotFoundException("No exhibition halls with such id"));

        return expositionRepository.findAllByHall(exhibitionHall);
    }

    @Override
    public List<Exposition> getAllExpositionsByThemeId(Long themeId) {
        Theme theme = themeService
                .getThemeById(themeId)
                .orElseThrow(() -> new NotFoundException("No theme with such id"));

        return expositionRepository.findAllByTheme(theme);
    }

    @Override
    public List<Exposition> getAllExpositionsByHallIdAndThemeId(Long hallId, Long themeId) {
        ExhibitionHall exhibitionHall = exhibitionHallService
                .getHallById(hallId)
                .orElseThrow(() -> new NotFoundException("No exhibition halls with such id"));
        Theme theme = themeService
                .getThemeById(themeId)
                .orElseThrow(() -> new NotFoundException("No theme with such id"));

        return expositionRepository.findAllByHallAndTheme(exhibitionHall, theme);
    }

    @Override
    public List<Exposition> getAllExpositions() {
        return expositionRepository.findAll();
    }

    @Override
    public Optional<Exposition> getExpositionById(Long expositionId) {
        return expositionRepository.findById(expositionId);
    }
}
