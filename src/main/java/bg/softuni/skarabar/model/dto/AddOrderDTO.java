package bg.softuni.skarabar.model.dto;

import java.util.List;

public class AddOrderDTO {

    private String orderDescription;
    private double totalPrice;
    private Long userEntityId;

    public AddOrderDTO(String orderDescription, double totalPrice, Long userEntityId) {
        this.orderDescription = orderDescription;
        this.totalPrice = totalPrice;
        this.userEntityId = userEntityId;
    }

    public Long getUserEntityId() {
        return userEntityId;
    }

    public AddOrderDTO setUserEntityId(Long userEntityId) {
        this.userEntityId = userEntityId;
        return this;
    }

    public AddOrderDTO() {
    }


    public String getOrderDescription() {
        return orderDescription;
    }

    public AddOrderDTO setOrderDescription(String orderDescription) {
        this.orderDescription = orderDescription;
        return this;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public AddOrderDTO setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
        return this;
    }
}
