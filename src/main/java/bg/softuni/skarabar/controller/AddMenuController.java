package bg.softuni.skarabar.controller;

import bg.softuni.skarabar.model.dto.AddFoodDTO;
import bg.softuni.skarabar.model.enums.FoodCategory;
import bg.softuni.skarabar.service.impl.FoodServiceImpl;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AddMenuController {
    private final FoodServiceImpl foodService;

    public AddMenuController(FoodServiceImpl foodService) {
        this.foodService = foodService;
    }

    @GetMapping("/admin")
    public String addMenu(){
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
@PostMapping("/admin")
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
}
