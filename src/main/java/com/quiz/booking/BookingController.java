package com.quiz.booking;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quiz.booking.bo.BookingBO;
import com.quiz.booking.domain.Booking;

@RequestMapping("/booking")
@Controller
public class BookingController {
	@Autowired
	private BookingBO bookingBO;

	@GetMapping("/check-booking-view")
	public String checkBookingView() {
		return "booking/checkBooking";
	}
	
	@GetMapping("/booking-list-view")
	public String bookingListView(Model model) {
		
		List<Booking> bookingList = bookingBO.getBookingList();
		model.addAttribute("bookingList", bookingList);
		return "booking/bookingList";
	}
	
	@GetMapping("/make-booking-view")
	public String makeBookingView() {
		return "booking/makeBooking";
	};
	
	@ResponseBody
	@DeleteMapping("/delete-booking")
	public Map<String, Object> deleteBooking(@RequestParam("id") int id) {
		
		boolean isDelete = bookingBO.deleteBookingById(id);
		Map<String, Object> result = new HashMap<>();
		result.put("code", 200);
		result.put("is_deleted_booking", isDelete);
		return result;
	}
	
	@ResponseBody
	@PostMapping("/insert-booking")
	public Map<String, Object> insertBooking(
			@RequestParam("name") String name,
			@RequestParam("headcount") int headcount,
			@RequestParam("date") LocalDate date,
			@RequestParam("day") int day,
			@RequestParam("phoneNumber") String phoneNumber,
			@RequestParam(value = "state", defaultValue = "대기중" ) String state ){
		
		boolean isSuccess = bookingBO.addBooking(name, headcount, date, day, phoneNumber, state);
		Map<String, Object> result = new HashMap<>();
		result.put("code", 200);
		result.put("is-inert-booking", isSuccess);
		return result;
	};
}
