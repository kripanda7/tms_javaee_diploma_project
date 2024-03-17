package by.teachmeskills.carparts.mapper;

import by.teachmeskills.carparts.dto.CartDto;
import by.teachmeskills.carparts.entity.CarpartsCart;
import by.teachmeskills.carparts.entity.Cart;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-17T12:55:13+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
@Component
public class CartMapperImpl implements CartMapper {

    @Override
    public Cart toEntity(CartDto cartDto) {
        if ( cartDto == null ) {
            return null;
        }

        Cart cart = new Cart();

        cart.setId( cartDto.getId() );
        cart.setQuantity( cartDto.getQuantity() );
        cart.setIsCompleted( cartDto.getIsCompleted() );
        List<CarpartsCart> list = cartDto.getCarparts();
        if ( list != null ) {
            cart.setCarparts( new ArrayList<CarpartsCart>( list ) );
        }

        return cart;
    }

    @Override
    public CartDto toDto(Cart cart) {
        if ( cart == null ) {
            return null;
        }

        CartDto cartDto = new CartDto();

        cartDto.setId( cart.getId() );
        cartDto.setQuantity( cart.getQuantity() );
        cartDto.setIsCompleted( cart.getIsCompleted() );
        List<CarpartsCart> list = cart.getCarparts();
        if ( list != null ) {
            cartDto.setCarparts( new ArrayList<CarpartsCart>( list ) );
        }

        return cartDto;
    }

    @Override
    public Cart partialUpdate(CartDto trackDto, Cart cart) {
        if ( trackDto == null ) {
            return null;
        }

        if ( trackDto.getId() != null ) {
            cart.setId( trackDto.getId() );
        }
        if ( trackDto.getQuantity() != null ) {
            cart.setQuantity( trackDto.getQuantity() );
        }
        if ( trackDto.getIsCompleted() != null ) {
            cart.setIsCompleted( trackDto.getIsCompleted() );
        }
        if ( cart.getCarparts() != null ) {
            List<CarpartsCart> list = trackDto.getCarparts();
            if ( list != null ) {
                cart.getCarparts().clear();
                cart.getCarparts().addAll( list );
            }
        }
        else {
            List<CarpartsCart> list = trackDto.getCarparts();
            if ( list != null ) {
                cart.setCarparts( new ArrayList<CarpartsCart>( list ) );
            }
        }

        return cart;
    }
}
