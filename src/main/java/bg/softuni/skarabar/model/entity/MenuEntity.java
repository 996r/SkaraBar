package bg.softuni.skarabar.model.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "menus")
public class MenuEntity extends BaseEntity {

    private String name;
    private String description;
    private double price;
@ManyToMany
@JoinTable(
        name = "menus_foods",
        joinColumns = @JoinColumn(name = "menu_id"),
        inverseJoinColumns = @JoinColumn(name = "food_id")
)
    private List<FoodEntity> foodEntityList = new ArrayList<>();
@ManyToMany(mappedBy = "menuEntityList")
        private List <Order> order;

    public String getName() {
        return name;
    }

    public MenuEntity setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public MenuEntity setDescription(String description) {
        this.description = description;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public MenuEntity setPrice(double price) {
        this.price = price;
        return this;
    }

    public List<FoodEntity> getFoodEntityList() {
        return foodEntityList;
    }

    public MenuEntity setFoodEntityList(List<FoodEntity> foodEntityList) {
        this.foodEntityList = foodEntityList;
        return this;
    }

    public List<Order> getOrder() {
        return order;
    }

    public MenuEntity setOrder(List<Order> order) {
        this.order = order;
        return this;
    }
}
