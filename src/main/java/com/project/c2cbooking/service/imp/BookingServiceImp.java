package com.project.c2cbooking.service.imp;

import com.project.c2cbooking.convert.BookingConvert;
import com.project.c2cbooking.model.BookingEntity;
import com.project.c2cbooking.model.RoomEntity;
import com.project.c2cbooking.model.UserEntity;
import com.project.c2cbooking.repository.BookingRepository;
import com.project.c2cbooking.repository.RoomRepository;
import com.project.c2cbooking.repository.UserRepository;
import com.project.c2cbooking.request.BookingRequest;
import com.project.c2cbooking.response.BookingResponse;
import com.project.c2cbooking.service.BookingService;
import com.project.c2cbooking.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingServiceImp implements BookingService {
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Override
    public void bookRoom(BookingRequest bookingRequest) {
        BookingEntity booking = new BookingEntity();
        booking.setCheckInDate(Util.convertStringToTimestamp(bookingRequest.getCheckInDate()));
        booking.setCheckOutDate(Util.convertStringToTimestamp(bookingRequest.getCheckOutDate()));
        booking.setBookingDate(Util.convertStringToTimestamp(bookingRequest.getBookingDate()));
        booking.setTotalCost(new BigDecimal(bookingRequest.getTotalCost()));
        UserEntity user = userRepository.findById(bookingRequest.getUserId()).get();
        booking.setUserEntity(user);
        RoomEntity room = roomRepository.findById(bookingRequest.getRoomId()).get();
        booking.setRoomEntity(room);
        booking.setInfantCount(bookingRequest.getInfantCount());
        booking.setGuestCount(bookingRequest.getGuestCount());
        booking.setIsPaid(bookingRequest.getIsPaid());
        booking.setDelFlag(false);

        bookingRepository.save(booking);
    }

    @Override
    public List<BookingResponse> getBookingByUserId(Integer userId) {
        List<BookingEntity> list = bookingRepository.getAllByUserEntity_IdAndIsPaidTrueOrderByIdDesc(userId);
        return list.stream().map(BookingConvert ::convert).collect(Collectors.toList());
    }

    @Override
    public BookingResponse getDetailBooking(Integer bookingId) {
        BookingEntity bookingEntity = bookingRepository.findById(bookingId).get();
        return BookingConvert.convert(bookingEntity);
    }

}
