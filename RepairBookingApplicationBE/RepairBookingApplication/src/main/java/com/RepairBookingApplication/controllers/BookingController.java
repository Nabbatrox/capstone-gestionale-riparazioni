package com.RepairBookingApplication.controllers;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.RepairBookingApplication.DTO.BookingDTO;
import com.RepairBookingApplication.models.Booking;
import com.RepairBookingApplication.models.Device;
import com.RepairBookingApplication.models.User;
import com.RepairBookingApplication.services.BookingService;
import com.RepairBookingApplication.services.DeviceService;
import com.RepairBookingApplication.services.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge=3600)
@RequestMapping("/api/booking")
public class BookingController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private DeviceService deviceService;
	
	@Autowired
	private BookingService bookingService;
	
	
	
	@GetMapping("/getAll")
//	@PreAuthorize("hasAnyRole('ADMIN','USER')")
	public List<Booking> getAllBooking() {
	    	
		List<Booking> res = bookingService.getAll();
	        
//	 	if (res.isEmpty()){
//	    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//	    	} else{
//	          return new ResponseEntity<>(res, HttpStatus.OK);
//	    	}
		return res;
	}
	
	
	
	
	@PostMapping("/save")
	//@PreAuthorize("hasRole('ROLE_ADMIN')")
	public Booking saveBooking(@RequestBody BookingDTO bookingDTO) {
		
		LocalDateTime reservationTime = LocalDateTime.parse(bookingDTO.getBookingDate());
		
			Booking booking = Booking.builder()
					.user(userService.getById(bookingDTO.getUserId()))
					.device(new HashSet<Device>())
					.bookedAt(LocalDateTime.now())
					.bookingDate(reservationTime)
					.expiringDate(reservationTime.plusHours(2))
					.build();
			Device device = Device.builder()
					.owner(userService.getById(bookingDTO.getUserId()))
					.model(bookingDTO.getModel())
					.serialnumber(bookingDTO.getSerialnumber())
					.deviceType(bookingDTO.getDeviceType())
					.build();
			deviceService.save(device);
			booking.addDevice(device);
			
		    return bookingService.save(booking);
		   
	}

}
