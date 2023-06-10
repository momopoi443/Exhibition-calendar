package com.example.exhibitioncalendar;

import com.example.exhibitioncalendar.entities.ExhibitionHall;
import com.example.exhibitioncalendar.entities.Exposition;
import com.example.exhibitioncalendar.entities.Theme;
import com.example.exhibitioncalendar.entities.User;
import com.example.exhibitioncalendar.repositories.ExhibitionHallRepository;
import com.example.exhibitioncalendar.repositories.ExpositionRepository;
import com.example.exhibitioncalendar.repositories.ThemeRepository;
import com.example.exhibitioncalendar.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@RequiredArgsConstructor
public class BootstrapData implements CommandLineRunner {

    private final ThemeRepository themeRepository;
    private final ExhibitionHallRepository hallRepository;
    private final ExpositionRepository expositionRepository;
    private final UserRepository userRepository;

    @Override
    @Transactional
    public void run(String... args) {
        Theme antiques = Theme.builder()
                .themeName("antiques")
                .build();
        Theme romanPaintings = Theme.builder()
                .themeName("roman paintings")
                .build();

        themeRepository.saveAll(List.of(antiques, romanPaintings));

        ExhibitionHall NAMU = ExhibitionHall.builder()
                .hallName("National Art Museum of Ukraine")
                .build();
        ExhibitionHall MWOA = ExhibitionHall.builder()
                .hallName("Museum of Western and Oriental Art")
                .build();

        hallRepository.saveAll(List.of(NAMU, MWOA));

        Exposition oldRomanPaintings = Exposition.builder()
                .expositionName("Old roman paintings")
                .hall(NAMU)
                .theme(romanPaintings)
                .ticketPrice(100.0)
                .build();
        Exposition romanAntiques = Exposition.builder()
                .expositionName("Roman antiques")
                .hall(NAMU)
                .theme(antiques)
                .ticketPrice(200.0)
                .build();
        Exposition ukrainianAntiques = Exposition.builder()
                .expositionName("Ukrainian antiques")
                .hall(MWOA)
                .theme(antiques)
                .ticketPrice(150.0)
                .build();

        expositionRepository.saveAll(List.of(
                oldRomanPaintings,
                romanAntiques,
                ukrainianAntiques
        ));

        User testUser = User.builder()
                .balance(10000000000000.0)
                .userName("test_user")
                .userPassword("test_user")
                .build();

        userRepository.save(testUser);
    }
}
