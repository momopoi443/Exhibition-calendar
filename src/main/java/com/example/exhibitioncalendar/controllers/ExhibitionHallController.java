package com.example.exhibitioncalendar.controllers;

import com.example.exhibitioncalendar.entities.ExhibitionHall;
import com.example.exhibitioncalendar.services.ExhibitionHallService;
import com.example.exhibitioncalendar.services.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class ExhibitionHallController {
    public static final String EXHIBITION_HALL_PATH = "/api/v1/exhibitionHalls";
    public static final String EXHIBITION_HALL_PATH_ID = EXHIBITION_HALL_PATH + "/{hallId}";

    private final ExhibitionHallService exhibitionHallService;

    @GetMapping(EXHIBITION_HALL_PATH)
    public String listExhibitionHalls(Model model) {
        List <ExhibitionHall> exhibitionHalls = exhibitionHallService.listExhibitionHalls();

        model.addAttribute("exhibitionHalls", exhibitionHalls);

        return "ListedExhibitionHalls";
    }

    @GetMapping(EXHIBITION_HALL_PATH_ID)
    public String getExhibitionHallById(@PathVariable Long hallId, Model model) {
        ExhibitionHall hall = exhibitionHallService
                .getHallById(hallId)
                .orElseThrow(() -> new NotFoundException("No hall with such id"));

        model.addAttribute("hall", hall);

        return "exhibitionHallInfo";
    }
}
