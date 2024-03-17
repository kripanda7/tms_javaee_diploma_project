package by.teachmeskills.carparts.dto;

import by.teachmeskills.carparts.entity.CarpartsCart;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class CartDto {
    private Long id;
    private Integer quantity;
    private Boolean isCompleted;
    private List<CarpartsCart> carparts;
}
