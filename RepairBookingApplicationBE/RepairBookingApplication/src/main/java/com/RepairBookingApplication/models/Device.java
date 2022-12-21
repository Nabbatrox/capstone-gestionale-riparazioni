package com.RepairBookingApplication.models;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Entity
@Data
@Table(name = "devices")
@AllArgsConstructor
@NoArgsConstructor
public class Device {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	private String serialnumber;
	
	@ManyToOne
	private User owner;
	
	
	@Enumerated(EnumType.STRING)
	private DeviceType deviceType;
	
	
	private String model;
	
	
	
	
	
}
