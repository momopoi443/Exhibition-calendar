package com.example.exhibitioncalendar.repositories;

import com.example.exhibitioncalendar.entities.Theme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ThemeRepository extends JpaRepository<Theme, Long> {
}
