package bg.softuni.skarabar.model.dto;

import bg.softuni.skarabar.model.enums.FoodCategory;

public class FoodInfoDTO {
    private long id;
    private String name;
    private double price;
    private FoodCategory foodCategory;

    public FoodInfoDTO() {
    }


    public FoodInfoDTO(long id, String name, double price, FoodCategory foodCategory) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.foodCategory = foodCategory;
    }

    public FoodInfoDTO setId(long id) {
        this.id = id;
        return this;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public FoodInfoDTO setName(String name) {
        this.name = name;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public FoodInfoDTO setPrice(double price) {
        this.price = price;
        return this;
    }

    public FoodCategory getFoodCategory() {
        return foodCategory;
    }

    public FoodInfoDTO setFoodCategory(FoodCategory foodCategory) {
        this.foodCategory = foodCategory;
        return this;
    }

    @Override
    public String toString() {
        return "FoodInfoDTO{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", foodCategory=" + foodCategory +
                '}';
    }
}
