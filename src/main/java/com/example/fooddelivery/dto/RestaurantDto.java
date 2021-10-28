package com.example.fooddelivery.dto;

import org.hibernate.validator.constraints.Length;

import com.sun.istack.NotNull;

public class RestaurantDto {
	@NotNull
	private Integer restaurantId;
	@NotNull
	private String resLogo;
	@NotNull
	private String name;
	@NotNull
	private String address;
	@NotNull
	@Length(max = 20,min = 5)
	private String phoneNumber;
	@NotNull
	@Length(max = 20,min = 5)
	private String password;
	
	public Integer getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(Integer restaurantId) {
		this.restaurantId = restaurantId;
	}
	public String getResLogo() {
		return resLogo;
	}
	public void setResLogo(String resLogo) {
		this.resLogo = resLogo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public RestaurantDto(Integer restaurantId, String resLogo, String name, String address, String phoneNumber,
			String password) {
		super();
		this.restaurantId = restaurantId;
		this.resLogo = resLogo;
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.password = password;
	}
	
	
	public RestaurantDto() {
		super();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		result = prime * result + ((resLogo == null) ? 0 : resLogo.hashCode());
		result = prime * result + ((restaurantId == null) ? 0 : restaurantId.hashCode());
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
		RestaurantDto other = (RestaurantDto) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		if (resLogo == null) {
			if (other.resLogo != null)
				return false;
		} else if (!resLogo.equals(other.resLogo))
			return false;
		if (restaurantId == null) {
			if (other.restaurantId != null)
				return false;
		} else if (!restaurantId.equals(other.restaurantId))
			return false;
		return true;
	}
	
}
