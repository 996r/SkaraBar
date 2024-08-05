package bg.softuni.skarabar.service;

import bg.softuni.skarabar.model.dto.AddMenuDTO;
import bg.softuni.skarabar.model.dto.MenuInfoDTO;
import bg.softuni.skarabar.model.entity.MenuEntity;

import java.util.List;

public interface MenuService {

    boolean createMenu(AddMenuDTO addMenuDTO);

    List<MenuInfoDTO> getAllMenus();

   MenuEntity getMenuById(long id);

    void deleteMenu(long MenuId);
}
