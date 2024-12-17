package com.coforge.training.airline.restController;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.coforge.training.airline.model.Booking;
import com.coforge.training.airline.repository.BookingRepository;
import com.coforge.training.airline.service.BookingService;




@RestController
@CrossOrigin(origins="http://localhost:3000")
@RequestMapping("/api/user")
public class BookingController {
	
	protected static final Logger logger = Logger.getLogger(BookingController.class.getName());


    @Autowired
    protected BookingService bookingService;
    @Autowired
    public BookingRepository book_repo;

    
   //For Creating new booking
   	@PostMapping("/new_booking")
    public String saveBooking(@RequestBody Booking booking) throws Exception
    {
        List<String> arr = booking.getSeatId();
       
        List<Booking> b = book_repo.findBySeatIdIn(arr);
        if (b.isEmpty()) {
            booking.setNumberOfSeats(booking.getNumberOfSeats());
             booking.setTotal_amount(booking.getTotal_amount());
            book_repo.save(booking);
            return "";
        }else
            throw new Exception("Seat is already booked"+b);
        }
	
    	
   	
       //For User to get Details of booking (bookingId)
        @GetMapping("/BookedFlight/{bookingId}")
	    public Optional<Booking> getBooking (@PathVariable("bookingId") long bookingId){
	    logger.info("getting Ticket: "+bookingId);
	    return book_repo.findById(bookingId) ;
	    }
	    
	
	    
       // For user to Cancel Booking OR Self Check-In 
	    @PutMapping("/booking/{bookingId}")
	    public Booking updateBooking(@RequestBody Booking booking,@PathVariable("bookingId") long ID) {
    	Booking dbResponse=book_repo.findById(ID).get();
    	dbResponse.setBooking_cancelled(booking.isBooking_cancelled());
    	dbResponse.setChecked_in(booking.isChecked_in());
    	logger.info("Saving Changes In Booked Ticket Of Booking Cancelled/ CheckIn: "+ID);
    	book_repo.save(dbResponse);

    	 if(booking.checked_in==true) {System.out.println("checked in");logger.info("Updated CheckIn Status");}
    	  if(booking.booking_cancelled==true)
    	  {booking.setChecked_in(false);System.out.println("Booking Cancelled");logger.info("Updated Booking Cancelled Status");}
    	return dbResponse;
    	 
        }
//	    
	 
      //Setting total amount for payment gateway fetched from passenger data 

//    public double setTotal_amount(Booking booking) {
//    	double tot_sum=0;
//    List<Passenger> list=	booking.getPassenger();
//    for (Flight flight :String) {
//    	tot_sum+=flight.getFlightCharge();
//
//    }
//    return tot_sum;
//    }



}
