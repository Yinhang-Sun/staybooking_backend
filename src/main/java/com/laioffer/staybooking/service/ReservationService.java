package com.laioffer.staybooking.service;

import com.laioffer.staybooking.repository.ReservationRepository;
import com.laioffer.staybooking.repository.StayReservationDateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {
    private ReservationRepository reservationRepository;
    private StayReservationDateRepository stayReservationDateRepository;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository,
                              StayReservationDateRepository stayReservationDateRepository) {
        this.reservationRepository = reservationRepository;
        this.stayReservationDateRepository = stayReservationDateRepository;
    }
}
