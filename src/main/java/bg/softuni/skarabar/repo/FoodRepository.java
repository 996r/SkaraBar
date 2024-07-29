package bg.softuni.skarabar.repo;

import bg.softuni.skarabar.model.entity.FoodEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository  extends JpaRepository <FoodEntity, Long> {
}
