package com.example.fooddelivery.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fooddelivery.dto.MenuDto;
import com.example.fooddelivery.services.MenuService;
@RestController
@RequestMapping("/menuservice")
public class MenuController {
	
			@Autowired
			private MenuService menuService;
			
			@PostMapping("/add")
			public MenuDto saveMenu(@Valid @RequestBody MenuDto menuDto) {
		        return menuService.saveMenu(menuDto);
		    }

			@GetMapping("/getall")
		    public List<MenuDto> getAllMenus() {
		        return menuService.getAllMenus();
		    }

			@DeleteMapping("/delete/{id}")
		    public MenuDto deleteMenu(@PathVariable(value = "id") int id) {
		        return menuService.deleteMenu(id);
		    }
			
			@PutMapping("/update")
			public MenuDto updateMenu(@Valid @RequestBody MenuDto menuDto){
				return menuService.updateMenu(menuDto);
			}
}
