package com.example.exhibitioncalendar.services;

import com.example.exhibitioncalendar.entities.ExhibitionHall;
import com.example.exhibitioncalendar.entities.Exposition;
import com.example.exhibitioncalendar.entities.Theme;
import com.example.exhibitioncalendar.repositories.ExpositionRepository;
import com.example.exhibitioncalendar.services.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ExpositionServiceImpl implements ExpositionService {

    private final ExpositionRepository expositionRepository;
    private final ExhibitionHallService exhibitionHallService;
    private final ThemeService themeService;

    @Override
    public List<Exposition> getAllExpositionsByHallId(Long hallId) {
        ExhibitionHall exhibitionHall = exhibitionHallService.getHallById(hallId);

        return expositionRepository.findAllByHall(exhibitionHall);
    }

    @Override
    public List<Exposition> getAllExpositionsByThemeId(Long themeId) {
        Theme theme = themeService.getThemeById(themeId);

        return expositionRepository.findAllByTheme(theme);
    }

    @Override
    public List<Exposition> getAllExpositionsByHallIdAndThemeId(Long hallId, Long themeId) {
        ExhibitionHall exhibitionHall = exhibitionHallService.getHallById(hallId);
        Theme theme = themeService.getThemeById(themeId);

        return expositionRepository.findAllByHallAndTheme(exhibitionHall, theme);
    }

    @Override
    public List<Exposition> getAllExpositions() {
        return expositionRepository.findAll();
    }

    @Override
    public Exposition getExpositionById(Long expositionId) {
        return expositionRepository
                .findById(expositionId)
                .orElseThrow(() -> {
                    var ex = new NotFoundException("No exposition with such id");
                    log.error(ex.getLocalizedMessage());
                    return ex;
                });
    }
}
