package com.example.exhibitioncalendar.services;

import com.example.exhibitioncalendar.dataModels.dtos.ExhibitionHallResponseDTO;
import com.example.exhibitioncalendar.dataModels.entities.ExhibitionHall;
import com.example.exhibitioncalendar.mappers.ExhibitionHallMapper;
import com.example.exhibitioncalendar.repositories.ExhibitionHallRepository;
import com.example.exhibitioncalendar.services.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Slf4j
public class ExhibitionHallServiceImpl implements ExhibitionHallService {
    private final ExhibitionHallRepository exhibitionHallRepository;
    private final ExhibitionHallMapper hallMapper;

    @Override
    public List<ExhibitionHallResponseDTO> listExhibitionHallResponseDTOs() {
        return listExhibitionHalls()
                .stream()
                .map(hallMapper::hallToHallResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ExhibitionHall> listExhibitionHalls() {
        return exhibitionHallRepository.findAll();
    }

    @Override
    public ExhibitionHallResponseDTO getHallResponseDTObyId(Long id) {
        return hallMapper.hallToHallResponseDTO(getHallById(id));
    }

    @Override
    public ExhibitionHall getHallById(Long id) {
        return exhibitionHallRepository
                .findById(id)
                .orElseThrow(() -> {
                    var ex = new NotFoundException("No hall with such id");
                    log.error(ex.getLocalizedMessage());
                    return ex;
                });
    }
}
