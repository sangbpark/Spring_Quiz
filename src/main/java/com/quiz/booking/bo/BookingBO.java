package com.quiz.booking.bo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.booking.domain.Booking;
import com.quiz.booking.mapper.BookingMapper;

@Service
public class BookingBO {
	@Autowired
	private BookingMapper bookingMapper;

	public List<Booking> getBookingList() {
		
		return bookingMapper.selectBookingList();
	};
	
	public boolean deleteBookingById(int id) {
		
		return bookingMapper.deleteBookingById(id) > 0 ? true : false;
	};
	
	public boolean addBooking(String name, int headcount, LocalDate date
			, int day, String phoneNumber) {
		return bookingMapper.insertBooking(name, headcount, date, day, phoneNumber) > 0 ? true : false;
	};
	
	public Booking getLatestBookingByNameAndPhoneNumber(String name, String phoneNumber) {
		List<Booking> bookingList = bookingMapper.selectBookingListByNameAndPhoneNumber(name, phoneNumber);
		return bookingList.isEmpty() ? null : bookingList.get(bookingList.size() - 1);
	};
}
