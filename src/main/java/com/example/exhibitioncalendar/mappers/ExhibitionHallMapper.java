package com.example.exhibitioncalendar.mappers;

import com.example.exhibitioncalendar.dataModels.dtos.ExhibitionHallResponseDTO;
import com.example.exhibitioncalendar.dataModels.entities.ExhibitionHall;
import org.mapstruct.Mapper;
import com.example.exhibitioncalendar.dataModels.entities.Exposition;

import java.util.List;
import java.util.stream.Collectors;

@Mapper
public class ExhibitionHallMapper {

    public ExhibitionHallResponseDTO hallToHallResponseDTO(ExhibitionHall hall) {
        if (hall == null) {
            return null;
        }

        ExhibitionHallResponseDTO hallDTO = new ExhibitionHallResponseDTO();

        hallDTO.setId(hall.getId());
        hallDTO.setHallName(hall.getHallName());

        List<Long> expositionIds = hall.getExpositions()
                .stream()
                .map(Exposition::getId)
                .collect(Collectors.toList());
        hallDTO.setExpositionIds(expositionIds);

        return hallDTO;
    }
}
