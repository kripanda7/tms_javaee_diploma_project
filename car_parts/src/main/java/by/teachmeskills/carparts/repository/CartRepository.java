package by.teachmeskills.carparts.repository;

import by.teachmeskills.carparts.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Long> {

    List<Cart> findByUserId(Long id);
}
