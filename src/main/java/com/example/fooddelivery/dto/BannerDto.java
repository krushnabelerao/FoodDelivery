package com.example.fooddelivery.dto;

import org.hibernate.validator.constraints.Length;

import com.sun.istack.NotNull;

public class BannerDto {
	@NotNull
	private Integer bannerId;
	@NotNull
	@Length(max = 20,min = 5)
	private String name;
	@NotNull
	@Length(max = 200,min = 5)
	private String type;
	@NotNull
	private String image;
	@NotNull
	private double width;
	@NotNull
	private double height;
	@NotNull
	@Length(max = 200,min = 5)
	private String allText;
	@NotNull
	@Length(max = 20,min = 5)
	private String description;
	
	public BannerDto(Integer bannerId2, String name2, String type, String allText2, double height2, double width2,
			String image2,String description) {
		this.bannerId=bannerId2;
		this.name=name2;
		this.type = type;
		this.allText = allText2;
		this.height = height2;
		this.width = width2;
		this.image = image2;
		this.description = description;
	}
	public BannerDto() {
		super();
	}
	public Integer getBannerId() {
		return bannerId;
	}
	public void setBannerId(Integer bannerId) {
		this.bannerId = bannerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public String getAllText() {
		return allText;
	}
	public void setAllText(String allText) {
		this.allText = allText;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((allText == null) ? 0 : allText.hashCode());
		result = prime * result + ((bannerId == null) ? 0 : bannerId.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		long temp;
		temp = Double.doubleToLongBits(height);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((image == null) ? 0 : image.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		temp = Double.doubleToLongBits(width);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BannerDto other = (BannerDto) obj;
		if (allText == null) {
			if (other.allText != null)
				return false;
		} else if (!allText.equals(other.allText))
			return false;
		if (bannerId == null) {
			if (other.bannerId != null)
				return false;
		} else if (!bannerId.equals(other.bannerId))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (Double.doubleToLongBits(height) != Double.doubleToLongBits(other.height))
			return false;
		if (image == null) {
			if (other.image != null)
				return false;
		} else if (!image.equals(other.image))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (Double.doubleToLongBits(width) != Double.doubleToLongBits(other.width))
			return false;
		return true;
	}

	
}
