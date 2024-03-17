package by.teachmeskills.carparts.service;

import by.teachmeskills.carparts.dto.CarPartDto;

import java.util.List;

public interface CarPartService {
    List<CarPartDto> getAllCarParts();

    CarPartDto getCarPartById(Long id);
}
