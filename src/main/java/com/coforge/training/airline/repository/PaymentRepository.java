package com.coforge.training.airline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.coforge.training.airline.model.Payment;


@RepositoryRestResource(path = "paymentBookings")
@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
   
    // Update payment status
    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("update Payment p set p.paymentStatus = ?1 where p.paymentId = ?2")
    void updatePaymentStatusById(String paymentStatus, Long paymentId);

    
    // Get one payment by id
    @RestResource(path = "paymentId")
    Payment findByPaymentId(@Param("paymentId") Long paymentId);


	
    
}