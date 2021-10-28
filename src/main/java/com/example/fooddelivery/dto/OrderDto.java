package com.example.fooddelivery.dto;

import java.util.Date;

import org.hibernate.validator.constraints.Length;

import com.sun.istack.NotNull;

public class OrderDto {
	@NotNull
	private Integer orderId;
	@NotNull
	private String name;
	@NotNull
	@Length(max = 20,min = 5)
	private String resAddress;
	@NotNull
	@Length(max = 20,min = 5)
	private String resPhoneNo;
	@NotNull
	private String orderStatus;
	@NotNull
	private Date orderTime;
	@NotNull
	private String estimationToDeliver;
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getResAddress() {
		return resAddress;
	}
	public void setResAddress(String resAddress) {
		this.resAddress = resAddress;
	}
	public String getResPhoneNo() {
		return resPhoneNo;
	}
	public void setResPhoneNo(String resPhoneNo) {
		this.resPhoneNo = resPhoneNo;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public Date getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}
	public String getEstimationToDeliver() {
		return estimationToDeliver;
	}
	public void setEstimationToDeliver(String estimationToDeliver) {
		this.estimationToDeliver = estimationToDeliver;
	}
	
	public OrderDto() {
		super();
	}
	public OrderDto(Integer orderId, String name, String resAddress, String resPhoneNo, String orderStatus,
			Date orderTime, String estimationToDeliver) {
		super();
		this.orderId = orderId;
		this.name = name;
		this.resAddress = resAddress;
		this.resPhoneNo = resPhoneNo;
		this.orderStatus = orderStatus;
		this.orderTime = orderTime;
		this.estimationToDeliver = estimationToDeliver;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((estimationToDeliver == null) ? 0 : estimationToDeliver.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		result = prime * result + ((orderStatus == null) ? 0 : orderStatus.hashCode());
		result = prime * result + ((orderTime == null) ? 0 : orderTime.hashCode());
		result = prime * result + ((resAddress == null) ? 0 : resAddress.hashCode());
		result = prime * result + ((resPhoneNo == null) ? 0 : resPhoneNo.hashCode());
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
		OrderDto other = (OrderDto) obj;
		if (estimationToDeliver == null) {
			if (other.estimationToDeliver != null)
				return false;
		} else if (!estimationToDeliver.equals(other.estimationToDeliver))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		if (orderStatus == null) {
			if (other.orderStatus != null)
				return false;
		} else if (!orderStatus.equals(other.orderStatus))
			return false;
		if (orderTime == null) {
			if (other.orderTime != null)
				return false;
		} else if (!orderTime.equals(other.orderTime))
			return false;
		if (resAddress == null) {
			if (other.resAddress != null)
				return false;
		} else if (!resAddress.equals(other.resAddress))
			return false;
		if (resPhoneNo == null) {
			if (other.resPhoneNo != null)
				return false;
		} else if (!resPhoneNo.equals(other.resPhoneNo))
			return false;
		return true;
	}
	

}
