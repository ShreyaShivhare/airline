package com.coforge.training.airline.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.coforge.training.airline.exception.ResourceNotFoundException;
import com.coforge.training.airline.model.Payment;


import com.coforge.training.airline.service.PaymentService;


import lombok.extern.slf4j.Slf4j;

@RequestMapping("/api")
@CrossOrigin(origins="http://localhost:3000") 
@RestController
@Slf4j
	public class PaymentController {

        @Autowired
	    private PaymentService paymentService;
	   
	    
	    @PostMapping("/payment")
	    public Payment savePaymentBooking(@RequestBody Payment payment) {
	       
	        Payment paymentBooking = paymentService.savePaymentBooking(payment);
	       
	        return payment;
	      // return paymentService.updatePaymentStatusById("pending", paymentService.getPaymentId());
	    }
	    
	    @GetMapping("/payment/paymentId")
	    public ResponseEntity<Payment>getPaymentById (@PathVariable("paymentId") Long paymentId) {
	    		//  throws ResourceNotFoundException {
	    	Payment payment = (Payment) paymentService.findByPaymentId(paymentId);
	    	return ResponseEntity.ok().body(payment);
	    	
	    }//findByPaymentId
	  


	
}
