package com.example.exhibitioncalendar.services;

import com.example.exhibitioncalendar.entities.ExhibitionHall;
import com.example.exhibitioncalendar.repositories.ExhibitionHallRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ExhibitionHallServiceImpl implements ExhibitionHallService {
    private final ExhibitionHallRepository exhibitionHallRepository;

    @Override
    public List<ExhibitionHall> listExhibitionHalls() {
        return exhibitionHallRepository.findAll();
    }

    @Override
    public Optional<ExhibitionHall> getHallById(Long id) {
        return exhibitionHallRepository.findById(id);
    }
}
