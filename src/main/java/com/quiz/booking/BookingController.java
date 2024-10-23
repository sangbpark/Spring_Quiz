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
		if (isDelete) {
			result.put("code", 200);
			result.put("result", "성공");
		} else {
			result.put("code", 500);
			result.put("error_message", "삭제할 대상이 없습니다.");			
		}
		return result;
	}
	
	@ResponseBody
	@PostMapping("/insert-booking")
	public Map<String, Object> insertBooking(
			@RequestParam("name") String name,
			@RequestParam("headcount") int headcount,
			@RequestParam("date") LocalDate date,
			@RequestParam("day") int day,
			@RequestParam("phoneNumber") String phoneNumber){
		
		boolean isSuccess = bookingBO.addBooking(name, headcount, date, day, phoneNumber);
		Map<String, Object> result = new HashMap<>();
		if (isSuccess) {
			result.put("code", 200);
			result.put("result", "성공");
		} else {
			result.put("code", 500);
			result.put("error_message", "예약에 실패했습니다.");
		}
		return result;
	};
	
	@ResponseBody
	@PostMapping("/search-booking")
	public Map<String, Object> getBookingListByNameAndPhoneNumber(
			@RequestParam("name") String name,
			@RequestParam("phoneNumber") String phoneNumber) {
		
		Booking booking = bookingBO.getLatestBookingByNameAndPhoneNumber(name, phoneNumber);
		Map<String, Object> result = new HashMap<>();
		if (booking != null) {
			result.put("code", 200);
			result.put("result", booking);
		} else {
			result.put("code", 500);
			result.put("error_message", "예약 내역이 없습니다.");
		}
		return result;
	}
}
