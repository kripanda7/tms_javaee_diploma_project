package by.teachmeskills.carparts.service.impl;

import by.teachmeskills.carparts.dto.CarPartDto;
import by.teachmeskills.carparts.exception.NotFoundException;
import by.teachmeskills.carparts.mapper.CarPartMapper;
import by.teachmeskills.carparts.repository.CarPartRepository;
import by.teachmeskills.carparts.service.CarPartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CarPartServiceImpl implements CarPartService {

    private final CarPartMapper carPartMapper;
    private final CarPartRepository carPartRepository;

    @Override
    public List<CarPartDto> getAllCarParts() {
        return carPartRepository.findAll().stream().map(carPartMapper::toDto).toList();
    }

    @Override
    public CarPartDto getCarPartById(Long id) {
        return carPartMapper.toDto(carPartRepository.findById(id).orElseThrow(() -> new NotFoundException("Carpart with id {} not found.", id)));
    }
}
