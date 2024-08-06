package bg.softuni.skarabar.service;

import bg.softuni.skarabar.model.dto.AddOrderDTO;

public interface OrderService {

    boolean createOrder(AddOrderDTO addOrderDTO);

}
