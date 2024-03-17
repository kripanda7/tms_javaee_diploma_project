package by.teachmeskills.carparts.repository;

import by.teachmeskills.carparts.entity.CarPart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarPartRepository extends JpaRepository<CarPart, Long> {
}
