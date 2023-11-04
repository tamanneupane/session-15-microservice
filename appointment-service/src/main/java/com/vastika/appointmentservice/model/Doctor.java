package com.vastika.appointmentservice.model;

import lombok.Data;

@Data
public class Doctor {

    private long id;

    private String nmcNumber;

    private String name;

    private String phoneNumber;

    private String email;

    private String speciality;

    private double fee;
}
