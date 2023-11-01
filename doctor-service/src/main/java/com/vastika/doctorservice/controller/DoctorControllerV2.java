package com.vastika.doctorservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v2")
@Tag(name = "Doctor API V2", description = "This is v2 API")
public class DoctorControllerV2 {

    @PostMapping(value = "/doctor")
    @Operation(
            summary = "Create Doctor V2",
            description = "This is used to create doctor fo v2"
    )
    public String createDoctor(){
        return "Doctor V2 created successfully";
    }

}
