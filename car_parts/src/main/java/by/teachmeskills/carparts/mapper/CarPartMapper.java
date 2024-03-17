package by.teachmeskills.carparts.mapper;

import by.teachmeskills.carparts.dto.CarPartDto;
import by.teachmeskills.carparts.entity.CarPart;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CarPartMapper {
    CarPart toEntity(CarPartDto carPartDto);

    CarPartDto toDto(CarPart carPart);
}
