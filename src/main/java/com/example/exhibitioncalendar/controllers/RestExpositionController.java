package com.example.exhibitioncalendar.controllers;

import com.example.exhibitioncalendar.entities.Exposition;
import com.example.exhibitioncalendar.services.ExpositionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RestExpositionController {
    public static final String EXPOSITION_PATH = "/api/v1/exposition";
    public static final String EXPOSITION_PATH_ID = EXPOSITION_PATH + "/{expositionId}";

    private final ExpositionService expositionService;

    @GetMapping(EXPOSITION_PATH)
    public List<Exposition> listExhibitionHalls(
            @RequestParam(name= "hallId", required=false) Long hallId,
            @RequestParam(name= "themeId", required=false) Long themeId
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

        return expositions;
    }

    @GetMapping(EXPOSITION_PATH_ID)
    public Exposition getExpositionById(@PathVariable Long expositionId) {
        return expositionService.getExpositionById(expositionId);
    }
}
