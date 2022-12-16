package com.RepairBookingApplication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.RepairBookingApplication.models.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

}
