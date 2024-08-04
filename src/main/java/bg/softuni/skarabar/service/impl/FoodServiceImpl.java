package bg.softuni.skarabar.service.impl;

import bg.softuni.skarabar.model.dto.AddFoodDTO;
import bg.softuni.skarabar.model.dto.FoodInfoDTO;
import bg.softuni.skarabar.model.entity.FoodEntity;
import bg.softuni.skarabar.repo.FoodRepository;
import bg.softuni.skarabar.service.FoodService;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FoodServiceImpl implements FoodService {
    private static final Logger logger = LoggerFactory.getLogger(FoodServiceImpl.class);

    private final FoodRepository foodRepository;


    public FoodServiceImpl(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;

    }

    @Override
    public boolean createFood(AddFoodDTO addFoodDTO) {

        FoodEntity foodEntity = new FoodEntity();
        foodEntity.setName(addFoodDTO.getName());
        foodEntity.setPrice(addFoodDTO.getPrice());
        foodEntity.setFoodCategory(addFoodDTO.getFoodCategory());

        foodRepository.save(foodEntity);
        return true;
    }
//@Transactional
    @Override
    public List<FoodInfoDTO> getAllFoods() {
    //    logger.info("Fetching all foods from the repository");

        List<FoodEntity> entities = foodRepository.findAll();
     //   logger.info("Fetched {} entities from the repository", entities.size());

        // Log the fetched entities
//        entities.forEach(entity -> logger.info("FoodEntity: {}", entity));

        List<FoodInfoDTO> foodList = entities.stream()
                .map(this::foodInfo)
                .collect(Collectors.toList());

        // Log detailed information about each FoodInfoDTO
     //   foodList.forEach(food -> logger.info("FoodInfoDTO: {}", food));

        return foodList;

    }

    private FoodInfoDTO foodInfo(FoodEntity foodEntity) {

        return new FoodInfoDTO(
                foodEntity.getId(),
                foodEntity.getName(),
                foodEntity.getPrice(),
                foodEntity.getFoodCategory());


    }
}
