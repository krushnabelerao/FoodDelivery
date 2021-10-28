package com.example.fooddelivery.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.fooddelivery.dto.MenuDto;
import com.example.fooddelivery.entity.Menu;
import com.example.fooddelivery.repo.MenuRepository;
@Service
@Transactional
public class MenuServiceImpl implements MenuService {

	@Autowired
	private MenuRepository menuRepository;
	@Override
	public MenuDto saveMenu(MenuDto menuDto) {
		Menu menu = new Menu();
		menu.setMenuId(menuDto.getMenuId());
		menu.setTitle(menuDto.getTitle());
		menu.setMenuType(menuDto.getMenuType());
		menu.setDescription(menuDto.getDescription());
		menuRepository.save(menu);
         return menuDto; 
	}

	@Override
	public List<MenuDto> getAllMenus() {
		List<Menu> menus = menuRepository.findAll();

		return menus.stream()
				.map(menuDto -> new MenuDto(menuDto.getMenuId(),menuDto.getTitle(),menuDto.getMenuType(),menuDto.getDescription()))
				.collect(Collectors.toList());
	}

	@Override
	public MenuDto deleteMenu(int id) {
		Menu menu = menuRepository.findById(id).orElse(null);
		MenuDto menuDto = new MenuDto();
		if (menu != null) {
			menuDto.setMenuId(menu.getMenuId());
			menuDto.setTitle(menu.getTitle());
			menuDto.setMenuType(menu.getMenuType());
			menuDto.setDescription(menu.getDescription());
			menuRepository.save(menu);
		}
		menuRepository.deleteById(id);
		return menuDto;
	}

	@Override
	public MenuDto updateMenu(MenuDto menuDto) {
		Menu existingMenu = menuRepository.findById(menuDto.getMenuId()).orElse(null);
		existingMenu.setTitle(menuDto.getTitle());
		existingMenu.setMenuType(menuDto.getMenuType());
		existingMenu.setDescription(menuDto.getDescription());
		menuRepository.save(existingMenu);
         return menuDto; 
	}

}
