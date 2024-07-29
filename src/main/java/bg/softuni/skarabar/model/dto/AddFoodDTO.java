package bg.softuni.skarabar.model.dto;

import bg.softuni.skarabar.model.enums.FoodCategory;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

public class AddFoodDTO {
    @NotEmpty
    private String name;
@Positive
    private double price;

    private FoodCategory foodCategory;

    public AddFoodDTO(String name, double price, FoodCategory foodCategory) {
        this.name = name;
        this.price = price;
        this.foodCategory = foodCategory;
    }
}
