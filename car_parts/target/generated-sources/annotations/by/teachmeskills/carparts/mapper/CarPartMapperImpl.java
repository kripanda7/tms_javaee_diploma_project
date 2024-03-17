package by.teachmeskills.carparts.mapper;

import by.teachmeskills.carparts.dto.CarPartDto;
import by.teachmeskills.carparts.entity.CarPart;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-17T12:55:13+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
@Component
public class CarPartMapperImpl implements CarPartMapper {

    @Override
    public CarPart toEntity(CarPartDto carPartDto) {
        if ( carPartDto == null ) {
            return null;
        }

        CarPart carPart = new CarPart();

        carPart.setId( carPartDto.getId() );
        carPart.setName( carPartDto.getName() );
        carPart.setCategory( carPartDto.getCategory() );
        carPart.setPrice( carPartDto.getPrice() );
        carPart.setIsAvailable( carPartDto.getIsAvailable() );

        return carPart;
    }

    @Override
    public CarPartDto toDto(CarPart carPart) {
        if ( carPart == null ) {
            return null;
        }

        CarPartDto carPartDto = new CarPartDto();

        carPartDto.setId( carPart.getId() );
        carPartDto.setName( carPart.getName() );
        carPartDto.setCategory( carPart.getCategory() );
        carPartDto.setPrice( carPart.getPrice() );
        carPartDto.setIsAvailable( carPart.getIsAvailable() );

        return carPartDto;
    }
}
