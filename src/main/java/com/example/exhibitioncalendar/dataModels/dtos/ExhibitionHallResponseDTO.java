package com.example.exhibitioncalendar.dataModels.dtos;

import lombok.Data;

import java.util.List;

@Data
public class ExhibitionHallResponseDTO {
    private Long id;
    private String hallName;
    private List<Long> expositionIds;
}
