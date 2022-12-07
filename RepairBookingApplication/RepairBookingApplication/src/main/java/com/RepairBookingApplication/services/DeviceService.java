package com.RepairBookingApplication.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RepairBookingApplication.models.Device;
import com.RepairBookingApplication.repositories.DeviceRepository;

@Service
public class DeviceService {
	
	@Autowired
	private DeviceRepository deviceRepository;
	
	public Device save(Device x) {
		return deviceRepository.save(x);
		
	}
	
	

}
