package com.example.exhibitioncalendar.services;

import com.example.exhibitioncalendar.entities.Theme;
import com.example.exhibitioncalendar.repositories.ThemeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ThemeServiceImpl implements ThemeService {

    private final ThemeRepository themeRepository;

    @Override
    public Optional<Theme> getThemeById(Long id) {
        return themeRepository.findById(id);
    }
}
