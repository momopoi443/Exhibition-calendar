package com.example.exhibitioncalendar.controllers;

import com.example.exhibitioncalendar.entities.Exposition;
import com.example.exhibitioncalendar.services.ExpositionService;
import com.example.exhibitioncalendar.services.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.mbeans.SparseUserDatabaseMBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ExpositionController {
    public static final String EXPOSITION_PATH = "/api/v1/exposition";
    public static final String EXPOSITION_PATH_ID = EXPOSITION_PATH + "/{expositionId}";

    private final ExpositionService expositionService;

    @GetMapping(EXPOSITION_PATH)
    public String listExhibitionHalls(
            @RequestParam(name= "hallId", required=false) Long hallId,
            @RequestParam(name= "themeId", required=false) Long themeId,
            Model model
    ) {
        List<Exposition> expositions;

        if (hallId != null && themeId != null) {
            expositions = expositionService.getAllExpositionsByHallIdAndThemeId(hallId, themeId);
        } else if (hallId != null) {
            expositions = expositionService.getAllExpositionsByHallId(hallId);
        } else if (themeId != null) {
            expositions = expositionService.getAllExpositionsByThemeId(themeId);
        } else {
            expositions = expositionService.getAllExpositions();
        }

        model.addAttribute("expositions", expositions);

        return "ListedExpositions";
    }

    @GetMapping(EXPOSITION_PATH_ID)
    public String getExpositionById(@PathVariable Long expositionId, Model model) {
        Exposition exposition = expositionService
                .getExpositionById(expositionId)
                .orElseThrow(() -> new NotFoundException("No exposition with such id"));

        model.addAttribute("exposition", exposition);

        return "expositionInfo";
    }
}
