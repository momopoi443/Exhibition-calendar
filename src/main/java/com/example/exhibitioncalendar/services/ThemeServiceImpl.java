package com.example.exhibitioncalendar.services;

import com.example.exhibitioncalendar.dataModels.entities.Theme;
import com.example.exhibitioncalendar.repositories.ThemeRepository;
import com.example.exhibitioncalendar.services.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ThemeServiceImpl implements ThemeService {

    private final ThemeRepository themeRepository;

    @Override
    public Theme getThemeById(Long id) {
        return themeRepository
                .findById(id)
                .orElseThrow(() -> {
                    var ex = new NotFoundException("No theme with such id");
                    log.error(ex.getLocalizedMessage());
                    return ex;
                });
    }
}
