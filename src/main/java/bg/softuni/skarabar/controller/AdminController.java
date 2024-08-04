package bg.softuni.skarabar.controller;

import bg.softuni.skarabar.model.dto.AddFoodDTO;
import bg.softuni.skarabar.model.dto.AddMenuDTO;
import bg.softuni.skarabar.model.enums.FoodCategory;
import bg.softuni.skarabar.service.impl.FoodServiceImpl;
import bg.softuni.skarabar.service.impl.MenuServiceImpl;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AdminController {
    private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

    private final FoodServiceImpl foodService;
    private final MenuServiceImpl menuService;

    public AdminController(FoodServiceImpl foodService, MenuServiceImpl menuService) {
        this.foodService = foodService;
        this.menuService = menuService;
    }

    @GetMapping("/admin")
    public String getAllFoods(Model model){
        model.addAttribute("allFoods",foodService.getAllFoods());
        model.addAttribute("allMenus",menuService.getAllMenus());
        return "admin";
    }
    @ModelAttribute("addFoodData")
    public AddFoodDTO addFoodData() {
        return new AddFoodDTO();
    }
    @ModelAttribute("allFoodCategories")
    public FoodCategory[] allFoodCategories(){
        return FoodCategory.values();
    }
    @ModelAttribute("addMenuData")
    public AddMenuDTO addMenuDTO(){
        return new AddMenuDTO();
    }


@PostMapping("/admin/add-food")
    public String doAddFood(
            @Valid AddFoodDTO data,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes
    ) {
        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("addFoodData", data);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.addFoodData",bindingResult);
            return "redirect:/admin";
        }
    boolean success = foodService.createFood(data);
    if(!success){
        redirectAttributes.addFlashAttribute("addFoodData",data);
        return "redirect:/admin";
    }
    return "redirect:/admin";
    }

    @PostMapping("/admin/add-menu")
    public String doAddMenu(
            @Valid AddMenuDTO data,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes
    ) {
        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("addMenuData", data);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.addMenuData",bindingResult);
            return "redirect:/admin";
        }
        boolean success = menuService.createMenu(data);
        if(!success){
            redirectAttributes.addFlashAttribute("addMenuData",data);
            return "redirect:/admin";
        }
        return "redirect:/admin";
    }
//    @DeleteMapping("/{id}")
//    public String deleteMenu(@PathVariable("id") Long id) {
//
//        menuService.deleteMenu(id);
//        return "redirect:/admin";
//    }

}
