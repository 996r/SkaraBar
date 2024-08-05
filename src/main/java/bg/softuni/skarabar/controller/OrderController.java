package bg.softuni.skarabar.controller;

import bg.softuni.skarabar.model.entity.MenuEntity;
import bg.softuni.skarabar.model.entity.SkaraUserDetails;
import bg.softuni.skarabar.model.entity.UserEntity;
import bg.softuni.skarabar.service.UserService;
import bg.softuni.skarabar.service.impl.MenuServiceImpl;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    private UserService userService;

    private List<String> selectedFoods = new ArrayList<>();
    private double totalPrice = 0.0;

    public OrderController(MenuServiceImpl menuService) {
        this.menuService = menuService;
    }

//    @GetMapping("/order")
//    public String newOrder2(@AuthenticationPrincipal UserDetails userDetails,
//                           Model model){
//        model.addAttribute("allMenus",menuService.getAllMenus());
//
//        if (userDetails instanceof SkaraUserDetails skaraUserDetails){
//            model.addAttribute("welcomeMessage",skaraUserDetails.getFullName());
//
//        }  else {
//            model.addAttribute("welcomeMessage", "Anonymous");
//        }
//        model.addAttribute("allMenus", menuService.getAllMenus());
//        model.addAttribute("selectedFoods", String.join("\n", selectedFoods));
//        model.addAttribute("totalPrice", totalPrice);
//        return "order";
//    }

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


    @PostMapping("/order/submit")
    public String submitOrder(@RequestParam("fullName") String fullName, @RequestParam("email") String email, @RequestParam("foodField") String foodField, @RequestParam("totalPrice") String totalPrice, RedirectAttributes redirectAttributes) {
        // Process the order submission here
        // For example, save the order details to the database

        // Clear selections after submitting
        selectedFoods.clear();
        this.totalPrice = 0.0;

        // Add a success message to redirect attributes
        redirectAttributes.addFlashAttribute("message", "Order created successfully!");

        return "redirect:/order/create"; // Redirect to the order creation page
    }


}
