package by.teachmeskills.carparts.mapper;

import by.teachmeskills.carparts.dto.CartDto;
import by.teachmeskills.carparts.entity.Cart;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CartMapper {
    Cart toEntity(CartDto cartDto);

    CartDto toDto(Cart cart);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Cart partialUpdate(CartDto trackDto, @MappingTarget Cart cart);
}
