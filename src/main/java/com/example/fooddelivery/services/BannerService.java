package com.example.fooddelivery.services;

import java.util.List;

import com.example.fooddelivery.dto.BannerDto;

public interface BannerService {
	public BannerDto saveBanner(BannerDto bannerDto);

    public List<BannerDto> getAllBanners(); 

    public BannerDto deleteBanner(int id); 
    
    public BannerDto updateBanner(BannerDto bannerDto);
}
