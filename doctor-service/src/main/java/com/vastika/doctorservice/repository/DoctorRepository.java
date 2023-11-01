package com.vastika.doctorservice.repository;

import com.vastika.doctorservice.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Long> {
    List<Doctor> findBySpeciality(String speciality);
}
