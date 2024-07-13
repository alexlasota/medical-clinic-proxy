package com.alexlasota.medical_clinic_proxy.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class SimpleDoctorDto {

    private Long id;
    private String firstName;
    private String phoneNumber;
    private String specialization;

}

