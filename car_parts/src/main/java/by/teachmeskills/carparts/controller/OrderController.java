package by.teachmeskills.carparts.controller;

import by.teachmeskills.carparts.config.security.JwtHelper;
import by.teachmeskills.carparts.dto.CartDto;
import by.teachmeskills.carparts.service.CartService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {

    private final CartService cartService;
    private final JwtHelper jwtHelper;

    @GetMapping(value = "/{id}")
    public CartDto getOrderById(@PathVariable("id") Long id) {
        return cartService.findById(id);
    }

    @GetMapping
    public List<CartDto> getOrdersByUser(@RequestHeader(AUTHORIZATION) String authHeader) {
        return cartService.findByUser(getUsername(authHeader));
    }

    @PostMapping()
    public ResponseEntity<CartDto> newCart(@RequestBody List<Long> carPartIds, @RequestHeader(AUTHORIZATION) String authHeader) {
        return ResponseEntity.ok(cartService.newCart(carPartIds, getUsername(authHeader)));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<CartDto> addToCart(@RequestBody List<Long> carPartIds, @PathVariable("id") Long id) {
        return ResponseEntity.ok(cartService.addToCart(carPartIds, id));
    }

    @PutMapping(value = "/complete/{id}")
    public ResponseEntity<CartDto> completeOrder(@PathVariable("id") Long id) {
        return ResponseEntity.ok(cartService.completeOrder(id));
    }

    @SneakyThrows
    private String getUsername(String authHeader) {
        String jwt = authHeader.substring("Bearer ".length()).trim();
        return jwtHelper.getTokenClaims(jwt).getUsername();
    }
}
