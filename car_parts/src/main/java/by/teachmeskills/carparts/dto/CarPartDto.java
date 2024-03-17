package by.teachmeskills.carparts.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class CarPartDto {
    private Long id;
    private String name;
    private Category category;
    private Double price;
    private Boolean isAvailable;
}
