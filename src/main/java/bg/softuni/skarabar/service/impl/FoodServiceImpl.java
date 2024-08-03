package bg.softuni.skarabar.service.impl;

import bg.softuni.skarabar.model.dto.AddFoodDTO;
import bg.softuni.skarabar.model.entity.FoodEntity;
import bg.softuni.skarabar.model.entity.UserEntity;
import bg.softuni.skarabar.model.enums.FoodCategory;
import bg.softuni.skarabar.repo.FoodRepository;
import bg.softuni.skarabar.repo.UserRepository;
import bg.softuni.skarabar.service.SkaraUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FoodServiceImpl {

    private final FoodRepository foodRepository;

    private final UserRepository userRepository;

    public FoodServiceImpl(FoodRepository foodRepository,  UserRepository userRepository) {
        this.foodRepository = foodRepository;
        this.userRepository = userRepository;
    }

    public boolean createFood(AddFoodDTO addFoodDTO){
//Optional<UserEntity> userEntity = userRepository.findByEmail(email);



        FoodEntity foodEntity = new FoodEntity();
        foodEntity.setName(addFoodDTO.getName());
        foodEntity.setPrice(addFoodDTO.getPrice());
        foodEntity.setFoodCategory(addFoodDTO.getFoodCategory());


        foodRepository.save(foodEntity);
        return true;
    }



}
