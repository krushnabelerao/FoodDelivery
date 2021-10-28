package com.example.fooddelivery.services;

import java.util.List;

import com.example.fooddelivery.dto.MenuDto;

public interface MenuService {
	public MenuDto saveMenu(MenuDto menuDto);

    public List<MenuDto> getAllMenus(); 

    public MenuDto deleteMenu(int id);
    
    public MenuDto updateMenu(MenuDto menuDto);
}
