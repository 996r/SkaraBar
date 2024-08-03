package bg.softuni.skarabar.repo;

import bg.softuni.skarabar.model.entity.FoodEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepository  extends JpaRepository <FoodEntity, Long> {
}
