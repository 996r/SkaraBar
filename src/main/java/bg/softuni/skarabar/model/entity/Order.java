package bg.softuni.skarabar.model.entity;

import jakarta.persistence.*;

import java.util.List;
@Entity
@Table(name = "orders")
public class Order extends BaseEntity {

    private double totalPrice;
    private String orderDescription;
@ManyToMany
@JoinTable(
        name = "orders_menus",
        joinColumns = @JoinColumn(name ="order_id"),
        inverseJoinColumns = @JoinColumn(name = "menu_id")
)
    private List<MenuEntity> menuEntityList;
@ManyToOne
    private UserEntity userEntity;

    public String getOrderDescription() {
        return orderDescription;
    }

    public Order setOrderDescription(String orderDescription) {
        this.orderDescription = orderDescription;
        return this;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public Order setTotalPrice(double unitPrice) {
        this.totalPrice = unitPrice;
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
