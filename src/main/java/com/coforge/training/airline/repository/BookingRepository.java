package com.coforge.training.airline.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coforge.training.airline.model.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {

		List<Booking> findBySeatIdIn(List<String> arr);
		
      }
