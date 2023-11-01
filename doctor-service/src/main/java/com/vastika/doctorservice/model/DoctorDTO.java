package com.vastika.doctorservice.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.Objects;

@Getter
@Component
@Slf4j
@ToString
public class DoctorDTO {

    @Setter
    @NotNull(message = "NMC number cannot be null")
    private String nmcNumber;

    @Setter
    @NotNull(message = "Name cannot be null")
    private String name;

    @Setter
    @NotNull(message = "Phone number cannot be null")
    private String phoneNumber;

    @Setter
    @NotNull
    @Email(message = "Email is not valid")
    private String email;

    @Setter
    @NotNull(message = "Speciality should not be null")
    private String speciality;

    @Setter
    @Positive(message = "Fee should be some positive value")
    private double fee;


    public Doctor mapToDoctor(){
        Doctor doctor = new Doctor();
        doctor.setNmcNumber(this.getNmcNumber());
        doctor.setName(this.getName());
        doctor.setPhoneNumber(this.getPhoneNumber());
        doctor.setEmail(this.getEmail());
        doctor.setSpeciality(Objects.requireNonNullElse(this.speciality, "General"));
        doctor.setFee(this.getFee());
        return doctor;
    }

}
