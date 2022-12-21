package com.RepairBookingApplication.DTO;

import java.time.LocalDateTime;

import com.RepairBookingApplication.models.DeviceType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookingDTO {
	
	private String serialnumber;
	private Long userId;
	private DeviceType deviceType;
	private String model;
	private String bookingDate;
	
}
