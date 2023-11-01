package com.vastika.doctorservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.print.Doc;

@Component
@Slf4j
@ToString
@Entity
@Table(name = "doctor_tbl", indexes = @Index(name = "speciality_index", columnList = "speciality"))
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    private long id;

    @Setter
    @Column(name = "nmc_number")
    @Getter
    private String nmcNumber;

    @Setter
    @Column(length = 80)
    @Getter
    private String name;

    @Setter
    @Column(name = "phone_number" ,length = 14)
    @Getter
    private String phoneNumber;

    @Setter
    @Column(length = 50)
    @Getter
    private String email;

    @Setter
    @Column(length = 80)
    @Getter
    private String speciality;

    @Setter
    @Column
    private double fee;
}
