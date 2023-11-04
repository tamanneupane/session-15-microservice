package com.vastika.appointmentservice.controller;

import com.vastika.appointmentservice.feignclient.DoctorServiceClient;
import com.vastika.appointmentservice.model.Doctor;
import com.vastika.appointmentservice.service.AppointmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping(value = "/api/v1")
@Slf4j
public class AppointmentController {

    @Autowired
    public AppointmentService appointmentService;

    @GetMapping(value = "/ping")
    public String ping(){
        return "UP appointment-service-2";
    }

    @GetMapping(value = "/book-appointment")
    public String bookAppointment(){
        try {
            appointmentService.bookAppointment();
        } catch (IOException e) {
            return "Booking unsuccessful";
        }
        return "Booking Successful";
    }

}
