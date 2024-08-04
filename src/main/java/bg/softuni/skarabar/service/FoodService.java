package bg.softuni.skarabar.service;

import bg.softuni.skarabar.model.dto.AddFoodDTO;
import bg.softuni.skarabar.model.dto.FoodInfoDTO;

import java.util.List;

public interface FoodService {
    boolean createFood(AddFoodDTO addFoodDTO);

    List<FoodInfoDTO> getAllFoods();
}
