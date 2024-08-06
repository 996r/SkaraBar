package bg.softuni.skarabar.service.impl;

import bg.softuni.skarabar.model.dto.AddOrderDTO;
import bg.softuni.skarabar.model.entity.Order;
import bg.softuni.skarabar.repo.OrderRepository;
import bg.softuni.skarabar.service.OrderService;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public boolean createOrder(AddOrderDTO addOrderDTO) {

        Order order= new Order();
        order.setOrderDescription(addOrderDTO.getOrderDescription());
        order.setTotalPrice(addOrderDTO.getTotalPrice());
        orderRepository.save(order);

        return true;
    }
}
