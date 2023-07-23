package com.example.exhibitioncalendar.services;

import com.example.exhibitioncalendar.dataModels.dtos.ExhibitionHallResponseDTO;
import com.example.exhibitioncalendar.dataModels.entities.ExhibitionHall;

import java.util.List;

public interface ExhibitionHallService {

    List<ExhibitionHallResponseDTO> listExhibitionHallResponseDTOs();

    List<ExhibitionHall> listExhibitionHalls();

    ExhibitionHallResponseDTO getHallResponseDTObyId(Long id);

    ExhibitionHall getHallById(Long id);
}
