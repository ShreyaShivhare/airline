package com.coforge.training.airline.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coforge.training.airline.model.Payment;

import com.coforge.training.airline.repository.PaymentRepository;


@Service

public class PaymentService {

	 @Autowired
    private PaymentRepository paymentRepository;

   public Payment savePaymentBooking(Payment payment) {
        return paymentRepository.save(payment);
    }


   
    public Payment updatePaymentStatusById(String paymentStatus, Long paymentId) {
        paymentRepository.updatePaymentStatusById(paymentStatus, paymentId);
        return paymentRepository.findByPaymentId(paymentId);
    }



	public Payment findByPaymentId(Long paymentId) {
		
		return paymentRepository.findByPaymentId(paymentId);
	}




	
}
