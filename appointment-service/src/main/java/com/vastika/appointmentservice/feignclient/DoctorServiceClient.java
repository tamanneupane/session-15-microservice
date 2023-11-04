package com.vastika.appointmentservice.feignclient;

import com.vastika.appointmentservice.model.Doctor;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "doctor-service", url = "http://localhost:8080/doctor-service")
@Component
public interface DoctorServiceClient {

    @RequestMapping(method = RequestMethod.GET ,value = "/api/v1/doctor/{doctorId}")
    public Doctor getDoctorDetail(@PathVariable(value = "doctorId") Long id);
}
