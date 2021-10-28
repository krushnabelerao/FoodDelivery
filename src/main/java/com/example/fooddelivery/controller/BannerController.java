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

import com.example.fooddelivery.dto.BannerDto;
import com.example.fooddelivery.services.BannerService;

@RestController
@RequestMapping("/bannerservice")
public class BannerController {
	@Autowired
	private BannerService bannerService;
	
	@PostMapping("/add")
	public BannerDto saveBanner(@Valid @RequestBody BannerDto bannerDto) {
        return bannerService.saveBanner(bannerDto);
    }

	@GetMapping("/getall")
    public List<BannerDto> getAllBanners() {
        return bannerService.getAllBanners();
    }

	@DeleteMapping("/delete/{id}")
    public BannerDto deleteBanner(@PathVariable(value = "id") int id) {
        return bannerService.deleteBanner(id);
    }
	
	@PutMapping("/update")
    public BannerDto updateBanner(@Valid @RequestBody BannerDto bannerDto) {
        return bannerService.updateBanner(bannerDto);
    }
}
