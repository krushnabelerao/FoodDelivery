package com.example.fooddelivery.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.fooddelivery.dto.BannerDto;
import com.example.fooddelivery.entity.Banner;
import com.example.fooddelivery.repo.BannerRepository;
@Service
@Transactional
public class BannerServiceImpl implements BannerService {

	@Autowired
	private BannerRepository bannerRepository;
	@Override
	public BannerDto saveBanner(BannerDto bannerDto) {
		Banner banner = new Banner();
		banner.setBannerId(bannerDto.getBannerId());
		banner.setName(bannerDto.getName());
		banner.setType(bannerDto.getType());
		banner.setAllText(bannerDto.getAllText());
		banner.setHeight(bannerDto.getHeight());
		banner.setImage(bannerDto.getImage());
		banner.setWidth(bannerDto.getWidth());
		banner.setDescription(bannerDto.getDescription());
		bannerRepository.save(banner);
         return bannerDto; 
	}

	@Override
	public List<BannerDto> getAllBanners() {
		List<Banner> banners = bannerRepository.findAll();

		return banners.stream()
				.map(bannerDto -> new BannerDto(bannerDto.getBannerId(),bannerDto.getName(),bannerDto.getType(),bannerDto.getAllText(),
						bannerDto.getHeight(),bannerDto.getWidth(),bannerDto.getImage(),bannerDto.getDescription()))
				.collect(Collectors.toList());
	}

	@Override
	public BannerDto deleteBanner(int id) {
		Banner banner = bannerRepository.findById(id).orElse(null);
		BannerDto bannerDto = new BannerDto();
		if (banner != null) {
			bannerDto.setBannerId(banner.getBannerId());
			bannerDto.setName(banner.getName());
			bannerDto.setType(banner.getType());
			bannerDto.setAllText(banner.getAllText());
			bannerDto.setHeight(banner.getHeight());
			bannerDto.setImage(banner.getImage());
			bannerDto.setWidth(banner.getWidth());
			bannerDto.setDescription(banner.getDescription());
		}
		bannerRepository.deleteById(id);
		return bannerDto;
	}

	@Override
	public BannerDto updateBanner(BannerDto bannerDto) {
		Banner existingBanner = bannerRepository.findById(bannerDto.getBannerId()).orElse(null);
		existingBanner.setName(bannerDto.getName());
		existingBanner.setType(bannerDto.getType());
		existingBanner.setAllText(bannerDto.getAllText());
		existingBanner.setHeight(bannerDto.getHeight());
		existingBanner.setImage(bannerDto.getImage());
		existingBanner.setWidth(bannerDto.getWidth());
		existingBanner.setDescription(bannerDto.getDescription());
		bannerRepository.save(existingBanner);
        return bannerDto;
	}

}
