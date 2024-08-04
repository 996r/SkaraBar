package bg.softuni.skarabar.model.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class AddMenuDTO {
    @NotEmpty
    private String name;
    @NotEmpty
    private String description;
    @Positive
    @NotNull
    private double price;

    public AddMenuDTO(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public AddMenuDTO() {
    }

    public String getName() {
        return name;
    }

    public AddMenuDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public AddMenuDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public AddMenuDTO setPrice(double price) {
        this.price = price;
        return this;
    }
}
