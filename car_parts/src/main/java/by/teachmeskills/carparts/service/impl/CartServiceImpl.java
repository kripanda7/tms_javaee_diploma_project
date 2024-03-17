package by.teachmeskills.carparts.service.impl;

import by.teachmeskills.carparts.dto.CartDto;
import by.teachmeskills.carparts.entity.CarpartsCart;
import by.teachmeskills.carparts.entity.Cart;
import by.teachmeskills.carparts.entity.User;
import by.teachmeskills.carparts.exception.NotFoundException;
import by.teachmeskills.carparts.mapper.CartMapper;
import by.teachmeskills.carparts.repository.CartRepository;
import by.teachmeskills.carparts.repository.UserRepository;
import by.teachmeskills.carparts.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
    private final CartMapper cartMapper;
    private final UserRepository userRepository;

    @Override
    @Transactional
    public CartDto addToCart(List<Long> carPartsIds, Long cartId) {
        Cart cart = cartRepository.findById(cartId).orElseThrow(() -> new NotFoundException("Cart with id {} not found.", cartId));
        if (cart != null && !cart.getIsCompleted()) {
            List<CarpartsCart> carpartsCarts = new ArrayList<>();
            for (Long carPartId : carPartsIds) {
                CarpartsCart carpartsCart = new CarpartsCart();
                carpartsCart.setCarts_id(cartId);
                carpartsCart.setCarparts_id(carPartId);
                carpartsCarts.add(carpartsCart);
            }
            cart.getCarparts().addAll(carpartsCarts);
            cart.setQuantity(cart.getQuantity() + carPartsIds.size());
            cartRepository.save(cart);
            return cartMapper.toDto(cart);
        } else {
            throw new NotFoundException("Order with id {} is comleted", cartId);
        }
    }

    @Override
    @Transactional
    public CartDto newCart(List<Long> carPartsIds, String login) {
        Cart cart = new Cart();
        cart.setQuantity(carPartsIds.size());
        cart.setIsCompleted(false);
        userRepository.findByLogin(login).ifPresent(u -> cart.setUserId(u.getId()));
        Cart savedCart = cartRepository.save(cart);
        List<CarpartsCart> carpartsCarts = new ArrayList<>();
        for (Long carPartId : carPartsIds) {
            CarpartsCart carpartsCart = new CarpartsCart();
            carpartsCart.setCarts_id(savedCart.getId());
            carpartsCart.setCarparts_id(carPartId);
            carpartsCarts.add(carpartsCart);
        }
        savedCart.getCarparts().addAll(carpartsCarts);
        return cartMapper.toDto(cart);
    }

    @Override
    @Transactional
    public CartDto completeOrder(Long id) {
        Cart cart = cartRepository.findById(id).orElseThrow(() -> new NotFoundException("Cart with id {} not found.", id));
        cart.setIsCompleted(true);
        cartRepository.save(cart);
        return cartMapper.toDto(cart);
    }

    @Override
    public List<CartDto> findAll() {
        return cartRepository.findAll().stream().map(cartMapper::toDto).toList();
    }

    @Override
    public CartDto findById(Long id) {
        return cartMapper.toDto(cartRepository.findById(id).orElseThrow(() -> new NotFoundException("Cart with id {} not found.", id)));
    }

    @Override
    public List<CartDto> findByUser(String login) {
        User user = userRepository.findByLogin(login).orElseThrow(() -> new NotFoundException("User with login {} not found.", login));
        return cartRepository.findByUserId(user.getId()).stream().map(cartMapper::toDto).toList();
    }

}
