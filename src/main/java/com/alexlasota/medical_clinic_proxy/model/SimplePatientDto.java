package com.alexlasota.medical_clinic_proxy.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class SimplePatientDto {

    private Long id;
    private String firstName;
    private String lastName;
}
