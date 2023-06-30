package com.example.exhibitioncalendar.services;

import com.example.exhibitioncalendar.entities.ExhibitionHall;
import com.example.exhibitioncalendar.repositories.ExhibitionHallRepository;
import com.example.exhibitioncalendar.services.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class ExhibitionHallServiceImpl implements ExhibitionHallService {
    private final ExhibitionHallRepository exhibitionHallRepository;

    @Override
    public List<ExhibitionHall> listExhibitionHalls() {
        return exhibitionHallRepository.findAll();
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
