package com.vastika.doctorservice;

import com.vastika.doctorservice.model.Doctor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class DoctorServiceApplication {

	// This is comment => single line comment

	/*

	Multiline comment
	sdaasdasdasd lakhsdlkasd lhkashdkjasd

	 */


	public static void main(String[] args) {
		SpringApplication.run(DoctorServiceApplication.class, args);
		log.info("Application is running");
	}

}
