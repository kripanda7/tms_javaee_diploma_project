package by.teachmeskills.carparts.service;

import by.teachmeskills.carparts.dto.CartDto;

import java.util.List;

public interface CartService {
    CartDto addToCart(List<Long> carPartsIds, Long cartId);

    CartDto newCart(List<Long> carPartsIds, String login);

    CartDto completeOrder(Long id);

    List<CartDto> findAll();

    CartDto findById(Long id);

    List<CartDto> findByUser(String login);
}
