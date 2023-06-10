package com.example.exhibitioncalendar.services;

import com.example.exhibitioncalendar.entities.Theme;

import java.util.Optional;

public interface ThemeService {

    Optional<Theme> getThemeById(Long id);
}
