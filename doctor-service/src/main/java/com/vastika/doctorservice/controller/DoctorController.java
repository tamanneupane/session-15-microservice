package com.vastika.doctorservice.controller;

import com.vastika.doctorservice.model.Doctor;
import com.vastika.doctorservice.model.DoctorDTO;
import com.vastika.doctorservice.model.ErrorResponse;
import com.vastika.doctorservice.repository.DoctorRepository;
import com.vastika.doctorservice.service.DoctorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
import javax.validation.Valid;
import java.util.List;

@RestController
@Slf4j
@RequestMapping(value = "/api/v1")
@Tag(name = "Doctor API V1", description = "This is v1 API")
public class DoctorController {

    /*
        HTTP METHOD
        1. GET
        2. POST
        3. PUT
        4. PATCH
        5. DELETE
     */

    /*
        HTTP CODE
        2XX
        200 - Success or OK
        201 - Created
        204 - No Content

        3XX

        4XX => Client Side Error
        400 - Bad Request
        404 - NOT FOUND
        405 - Method not allowed

        5XX => Server Side Error
    */

    // CRUD - Create , Read, Update, Delete

    @Autowired
    private DoctorService doctorService;


    public DoctorController(){
        log.info("Doctor controller object is created");
    }

    @GetMapping
    public String index(){
        return "Doctor Index";
    }

    @GetMapping(value = "/ping")
    public String ping(){
        return "Doctor Service is UP";
    }

    @Operation(
            summary = "Create Doctor",
            description = "This is used to create doctor"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Doctor.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "400", content = { @Content(schema = @Schema(implementation = ErrorResponse.class)) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema(implementation = ErrorResponse.class)) }) })
    @PostMapping(value = "/doctor")
    public ResponseEntity<Doctor> createDoctor(@Valid @RequestBody DoctorDTO doctorDTO){
        log.info(doctorDTO.toString());
        Doctor doctor = doctorService.saveDoctor(doctorDTO);

        return new ResponseEntity<>(doctor, HttpStatus.CREATED);
    }

    @Operation(
            summary = "List Doctor",
            description = "This is used to list down all doctors"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(array = @ArraySchema(schema = @Schema(implementation = Doctor.class)), mediaType = "application/json") }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema(implementation = ErrorResponse.class)) }) })
    @GetMapping(value = "/doctor")
    public ResponseEntity<List<Doctor>> getDoctors(){
        return new ResponseEntity<>(doctorService.listAllDoctors(), HttpStatus.OK);
    }

    @GetMapping(value = "/doctor/{doctorId}")
    public ResponseEntity<Doctor> getDoctorDetail(@PathVariable(value = "doctorId") Long id){
        log.info(String.valueOf(id));
        Doctor doctor = doctorService.getDoctorById(id);
        return new ResponseEntity<>(doctor, HttpStatus.OK) ;
    }


    // localhost:port/doctor/speciality?sep=<>
    @GetMapping(value = "/doctor/speciality")
    public ResponseEntity<List<Doctor>> getDoctorWithSpecialities(@RequestParam(value = "sep") String special){
        log.info(String.valueOf(special));
        return new ResponseEntity<>(doctorService.getDoctorBySpeciality(special), HttpStatus.OK);
    }

    @PutMapping(value = "/doctor/{doctorId}")
    public ResponseEntity<Doctor> update(@PathVariable("doctorId") Long doctorId,@RequestBody DoctorDTO doctorDTO){
        log.info(String.valueOf(doctorId));
        log.info(doctorDTO.toString());
        return new ResponseEntity<>(doctorService.updateDoctor(doctorId, doctorDTO), HttpStatus.OK);
    }

    @DeleteMapping(value = "/doctor/{doctorId}")
    public ResponseEntity<String> delete(@PathVariable("doctorId") Long doctorId){
        log.info(String.valueOf(doctorId));
        doctorService.deleteDoctor(doctorId);
        return new ResponseEntity<>("Doctor Deleted",HttpStatus.NO_CONTENT);
    }
}
