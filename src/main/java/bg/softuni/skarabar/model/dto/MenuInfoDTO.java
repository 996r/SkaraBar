package bg.softuni.skarabar.model.dto;

public class MenuInfoDTO {
    private long id;
    private String name;

    private double price;
    private String description;

    public MenuInfoDTO(long id, String name, double price, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public MenuInfoDTO setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public MenuInfoDTO setName(String name) {
        this.name = name;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public MenuInfoDTO setPrice(double price) {
        this.price = price;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public MenuInfoDTO setDescription(String description) {
        this.description = description;
        return this;
    }
}
