package bg.softuni.skarabar.service;

import bg.softuni.skarabar.model.dto.AddMenuDTO;
import bg.softuni.skarabar.model.dto.MenuInfoDTO;

import java.util.List;

public interface MenuService {

    boolean createMenu(AddMenuDTO addMenuDTO);

    List<MenuInfoDTO> getAllMenus();

    void deleteMenu(long MenuId);
}
