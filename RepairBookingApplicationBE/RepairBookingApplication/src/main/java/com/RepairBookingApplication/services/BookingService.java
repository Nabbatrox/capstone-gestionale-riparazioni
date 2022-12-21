package com.RepairBookingApplication.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RepairBookingApplication.exceptions.NotFoundException;
import com.RepairBookingApplication.models.Booking;
import com.RepairBookingApplication.repositories.BookingRepository;

@Service
public class BookingService {
	
	@Autowired
	private BookingRepository bookingRepository;
	
	public Booking save(Booking b) {
		return bookingRepository.save(b);
	}
	
    public List<Booking> getAll() {
        return bookingRepository.findAll();
    }
    
	public Booking getById(Long id) {
		
		Optional<Booking> booking = bookingRepository.findById(id);
		
		if(booking.isEmpty()) throw new NotFoundException("Booking not found");
		
		return booking.get();
		
	}

}
