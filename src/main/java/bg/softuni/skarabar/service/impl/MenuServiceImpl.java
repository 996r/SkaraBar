package bg.softuni.skarabar.service.impl;

import bg.softuni.skarabar.model.dto.AddMenuDTO;
import bg.softuni.skarabar.model.dto.FoodInfoDTO;
import bg.softuni.skarabar.model.dto.MenuInfoDTO;
import bg.softuni.skarabar.model.entity.FoodEntity;
import bg.softuni.skarabar.model.entity.MenuEntity;
import bg.softuni.skarabar.repo.MenuRepository;
import bg.softuni.skarabar.service.MenuService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MenuServiceImpl  implements MenuService {
        private final MenuRepository menuRepository;

    public MenuServiceImpl(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }



    @Override
    public boolean createMenu(AddMenuDTO addMenuDTO) {
        MenuEntity menu = new MenuEntity();
        menu.setName(addMenuDTO.getName());
        menu.setDescription(addMenuDTO.getDescription());
        menu.setPrice(addMenuDTO.getPrice());

        menuRepository.save(menu);
        return true;
    }

    @Override
    public List<MenuInfoDTO> getAllMenus() {

        List<MenuEntity> entities = menuRepository.findAll();

        List<MenuInfoDTO> menuList = entities.stream()
                .map(this::menuInfo)
                .collect(Collectors.toList());

        return menuList;
    }

    @Override
    public MenuEntity getMenuById(long id) {
        Optional<MenuEntity> menuEntityOptional = menuRepository.findById(id);
        if (menuEntityOptional.isPresent()) {
            return menuEntityOptional.get();
        } else {
            throw new IllegalArgumentException("Menu with id " + id + " not found");
        }
    }

    @Override
    public void deleteMenu(long menuId) {
        menuRepository.deleteById(menuId);
    }

    private MenuInfoDTO menuInfo(MenuEntity menuEntity) {

        return new MenuInfoDTO(
                menuEntity.getId(),
                menuEntity.getName(),
                menuEntity.getPrice(),
                menuEntity.getDescription());
    }
}
