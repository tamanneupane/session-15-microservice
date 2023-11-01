package com.vastika.doctorservice.service;

import com.vastika.doctorservice.exceptions.DoctorNotFoundException;
import com.vastika.doctorservice.model.Doctor;
import com.vastika.doctorservice.model.DoctorDTO;
import com.vastika.doctorservice.repository.DoctorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class DoctorServiceImpl implements DoctorService{

    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public Doctor saveDoctor(DoctorDTO doctorDTO) {
       Doctor doctor = doctorDTO.mapToDoctor();
       return doctorRepository.save(doctor);
    }

    @Override
    public List<Doctor> listAllDoctors() {
        return doctorRepository.findAll();
    }

    @Override
    public void deleteDoctor(Long id) throws EmptyResultDataAccessException {
        //TODO : EmptyResultDataAccessException should be handled
        doctorRepository.deleteById(id);
    }

    @Override
    public Doctor getDoctorById(Long doctorId) {
        Optional<Doctor> optionalDoctor = doctorRepository.findById(doctorId);
        if(optionalDoctor.isPresent()){
            return optionalDoctor.get();
        }
        throw new DoctorNotFoundException("Doctor with ID not found");
    }

    @Override
    public Doctor updateDoctor(Long doctorId, DoctorDTO doctorDTO) {
        Optional<Doctor> optionalDoctor = doctorRepository.findById(doctorId);
        if(optionalDoctor.isPresent()){
            Doctor doctor = optionalDoctor.get(); // This doctor has id because it is pulled from DB
           doctor.setFee(doctorDTO.getFee());
           doctor.setName(doctorDTO.getName());
           doctor.setSpeciality(doctorDTO.getSpeciality());
           doctor.setEmail(doctorDTO.getEmail());
           doctor.setPhoneNumber(doctorDTO.getPhoneNumber());
           doctor.setNmcNumber(doctorDTO.getNmcNumber());

           return doctorRepository.save(doctor);

        }
        throw new DoctorNotFoundException("Doctor with ID not found");
    }

    @Override
    public List<Doctor> getDoctorBySpeciality(String speciality) {
        return doctorRepository.findBySpeciality(speciality);
    }
}
