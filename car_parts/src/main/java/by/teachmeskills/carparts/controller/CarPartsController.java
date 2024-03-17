package by.teachmeskills.carparts.controller;

import by.teachmeskills.carparts.dto.CarPartDto;
import by.teachmeskills.carparts.service.CarPartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/carparts")
@RequiredArgsConstructor
public class CarPartsController {

    private final CarPartService carPartService;
    @GetMapping
    public List<CarPartDto> getCarParts() {
        return carPartService.getAllCarParts();
    }

}
