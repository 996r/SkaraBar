package bg.softuni.skarabar.model.entity;

import bg.softuni.skarabar.model.enums.FoodCategory;
import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;

import java.util.List;
@Entity
@Table(name ="foods")
public class FoodEntity  extends BaseEntity{

    private String name;
    @Positive
    private double price;
    @Enumerated(EnumType.STRING)
    private FoodCategory foodCategory;

@ManyToMany(mappedBy = "foodEntityList")
    private List<MenuEntity> menuEntityList;

    public String getName() {
        return name;
    }

    public FoodEntity setName(String name) {
        this.name = name;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public FoodEntity setPrice(double price) {
        this.price = price;
        return this;
    }

    public FoodCategory getFoodCategory() {
        return foodCategory;
    }

    public FoodEntity setFoodCategory(FoodCategory foodCategory) {
        this.foodCategory = foodCategory;
        return this;
    }

    public List<MenuEntity> getMenuEntityList() {
        return menuEntityList;
    }

    public FoodEntity setMenuEntityList(List<MenuEntity> menuEntityList) {
        this.menuEntityList = menuEntityList;
        return this;
    }

    @Override
    public String toString() {
        return "FoodEntity{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", foodCategory=" + foodCategory +
                ", menuEntityList=" + menuEntityList +
                '}';
    }
}
