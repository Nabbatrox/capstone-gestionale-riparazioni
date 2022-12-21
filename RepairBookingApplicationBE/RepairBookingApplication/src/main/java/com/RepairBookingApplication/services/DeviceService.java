package com.RepairBookingApplication.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.RepairBookingApplication.exceptions.NotFoundException;
import com.RepairBookingApplication.models.Device;
import com.RepairBookingApplication.repositories.DeviceRepository;

@Service
public class DeviceService {
	
	@Autowired
	private DeviceRepository deviceRepository;
	
	public Device save(Device x) {
		
		return deviceRepository.save(x);
		
	}
	
    public List<Device> getAll() {
        return deviceRepository.findAll();
    }
	
	public Device getById(Long id) {
		
		Optional<Device> device = deviceRepository.findById(id);
		
		if(device.isEmpty()) throw new NotFoundException("Device not found");
		
		return device.get();
		
	}
	
	
	public void deleteById(Long id) {
		deviceRepository.deleteById(id);
	}
	
}
