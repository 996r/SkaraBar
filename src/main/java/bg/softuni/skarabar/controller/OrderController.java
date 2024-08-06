package bg.softuni.skarabar.controller;

import bg.softuni.skarabar.model.dto.AddMenuDTO;
import bg.softuni.skarabar.model.dto.AddOrderDTO;
import bg.softuni.skarabar.model.entity.MenuEntity;
import bg.softuni.skarabar.model.entity.SkaraUserDetails;
import bg.softuni.skarabar.model.entity.UserEntity;
import bg.softuni.skarabar.service.UserService;
import bg.softuni.skarabar.service.impl.MenuServiceImpl;
import bg.softuni.skarabar.service.impl.OrderServiceImpl;
import jakarta.validation.Valid;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Controller
//@RequestMapping("/orders")
public class OrderController {
    private final MenuServiceImpl menuService;
    private final OrderServiceImpl orderService;
    private UserService userService;

    private List<String> selectedFoods = new ArrayList<>();
    private double totalPrice = 0.0;

    public OrderController(MenuServiceImpl menuService, OrderServiceImpl orderService) {
        this.menuService = menuService;
        this.orderService = orderService;
    }

    @GetMapping("/order")
    public String newOrder(@AuthenticationPrincipal UserDetails userDetails, Model model) {
        if (userDetails instanceof SkaraUserDetails skaraUserDetails) {
            String fullName = skaraUserDetails.getFullName();
            model.addAttribute("user", skaraUserDetails.getFullName());
        } else {

        }
        model.addAttribute("allMenus", menuService.getAllMenus());
        model.addAttribute("selectedFoods", String.join("\n", selectedFoods));
        model.addAttribute("totalPrice", totalPrice);
        return "order";
    }

@PostMapping("/orders/addFood")
public String addFood(@RequestParam("menuId") Long menuId,
                      @RequestParam("quantity") int quantity,
                      Model model,
                      @AuthenticationPrincipal UserDetails userDetails,
                      RedirectAttributes redirectAttributes) {

    MenuEntity menu = menuService.getMenuById(menuId);
    String selectedFood = menu.getName() + " - " + menu.getPrice() + " lev" + "\n";
    selectedFoods.add(selectedFood);
    totalPrice += menu.getPrice() * quantity;
    redirectAttributes.addFlashAttribute("selectedFoods", selectedFoods);
    redirectAttributes.addFlashAttribute("totalPrice", totalPrice);
    redirectAttributes.addFlashAttribute("welcomeMessage", userDetails.getUsername());

    return "redirect:/order";
}


    @PostMapping("/orders/submit")
    public String submitOrder(
            @AuthenticationPrincipal UserDetails userDetails, Model model,
            @Valid AddOrderDTO data,
                              @RequestParam("foodField") String foodField,
                              @RequestParam("totalPrice") String totalPrice,
                              BindingResult bindingResult,
                              RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("addOrderData", data);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.addOrderData", bindingResult);
            return "redirect:/order";
        }
        data.setOrderDescription(foodField);
        data.setTotalPrice(Double.parseDouble(totalPrice));
       // data.setUserEntityId(Long.parseLong("1"));
        boolean success = orderService.createOrder(data);


        if (!success) {
            redirectAttributes.addFlashAttribute("addOrderData", data);
            redirectAttributes.addFlashAttribute("message", "Failed to create order.");
            return "redirect:/order";

        }
        redirectAttributes.addFlashAttribute("message", "Order created successfully!");
        selectedFoods.clear();
        this.totalPrice = 0.0;
        return "redirect:/order";

    }

    }
