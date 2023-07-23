package com.example.exhibitioncalendar.controllers;

import com.example.exhibitioncalendar.dataModels.dtos.ExhibitionHallResponseDTO;
import com.example.exhibitioncalendar.services.ExhibitionHallService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RestExhibitionHallController {
    public static final String EXHIBITION_HALL_PATH = "/api/v1/exhibitionHalls";
    public static final String EXHIBITION_HALL_PATH_ID = EXHIBITION_HALL_PATH + "/{hallId}";

    private final ExhibitionHallService exhibitionHallService;

    @GetMapping(EXHIBITION_HALL_PATH)
    public List<ExhibitionHallResponseDTO> listExhibitionHalls() {
        return exhibitionHallService.listExhibitionHallResponseDTOs();
    }

    @GetMapping(EXHIBITION_HALL_PATH_ID)
    public ExhibitionHallResponseDTO getExhibitionHallById(@PathVariable Long hallId) {
        return exhibitionHallService.getHallResponseDTObyId(hallId);
    }
}
