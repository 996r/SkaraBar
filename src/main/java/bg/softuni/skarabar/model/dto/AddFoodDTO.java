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

    public AddFoodDTO() {

    }

    public String getName() {
        return name;
    }

    public AddFoodDTO setName(String name) {
        this.name = name;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public AddFoodDTO setPrice(double price) {
        this.price = price;
        return this;
    }

    public FoodCategory getFoodCategory() {
        return foodCategory;
    }

    public AddFoodDTO setFoodCategory(FoodCategory foodCategory) {
        this.foodCategory = foodCategory;
        return this;
    }
}
