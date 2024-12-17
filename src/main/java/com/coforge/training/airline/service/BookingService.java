package com.coforge.training.airline.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coforge.training.airline.model.Booking;
import com.coforge.training.airline.repository.BookingRepository;

@Service
@Transactional
public class BookingService {
	
	    @Autowired
	    private BookingRepository bookingRepository;

	    
	    public List<Booking> listAll(){
			return bookingRepository.findAll();   
		}

	    public Booking saveFlight(Booking b) {  
			return bookingRepository.save(b);   
		}



}
