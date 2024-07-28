package bg.softuni.skarabar.model.entity;

import jakarta.persistence.*;

import java.util.List;
@Entity
@Table(name = "orders")
public class Order extends BaseEntity {

    private double unitPrice;
    private int quantity;
@ManyToMany
@JoinTable(
        name = "orders_menus",
        joinColumns = @JoinColumn(name ="order_id"),
        inverseJoinColumns = @JoinColumn(name = "menu_id")
)
    private List<MenuEntity> menuEntityList;
@ManyToOne
    private UserEntity userEntity;

    public double getUnitPrice() {
        return unitPrice;
    }

    public Order setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
        return this;
    }

    public int getQuantity() {
        return quantity;
    }

    public Order setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public List<MenuEntity> getMenuEntityList() {
        return menuEntityList;
    }

    public Order setMenuEntityList(List<MenuEntity> menuEntityList) {
        this.menuEntityList = menuEntityList;
        return this;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public Order setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
        return this;
    }
}
