package bg.softuni.skarabar.repo;

import bg.softuni.skarabar.model.entity.MenuEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<MenuEntity, Long> {
}
