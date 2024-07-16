package com.alexlasota.medical_clinic_proxy.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VisitDto {

    private Long id;
    private LocalDateTime visitStartDate;
    private LocalDateTime visitEndDate;
    private SimplePatientDto patient;
    private SimpleDoctorDto doctor;
    private boolean available;
}