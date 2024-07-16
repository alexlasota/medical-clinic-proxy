package com.alexlasota.medical_clinic_proxy.service;

import com.alexlasota.medical_clinic_proxy.client.MedicalClinicClient;
import com.alexlasota.medical_clinic_proxy.model.VisitDto;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.security.InvalidParameterException;
import java.time.LocalDate;
import java.util.List;

@Service
public class ProxyVisitService {

    private final MedicalClinicClient medicalClinicClient;

    public ProxyVisitService(MedicalClinicClient medicalClinicClient) {
        this.medicalClinicClient = medicalClinicClient;
    }

    public List<VisitDto> getVisitsByPatientId(Long patientId) {
        if (patientId == null || patientId <= 0) {
            throw new InvalidParameterException("INCORRECT PATIENT ID!");
        }
        return medicalClinicClient.getVisitsByPatientId(patientId);
    }

    public VisitDto assignPatientToVisit(@PathVariable Long visitId, @PathVariable Long patientId) {
        if (visitId == null || visitId <= 0) {
            throw new InvalidParameterException("INCORRECT VISIT ID!");
        }
        if (patientId == null || patientId <= 0) {
            throw new InvalidParameterException("INCORRECT PATIENT ID!");
        }
        VisitDto visit = medicalClinicClient.assignPatientToVisit(visitId, patientId);
        if (visit == null) {
            throw new InvalidParameterException("VISIT WITH GIVEN ID NOT FOUND: " + visitId);
        }
        return visit;
    }

    public List<VisitDto> getAvailableVisitsByDoctorId(Long doctorId) {
        if (doctorId == null || doctorId <= 0) {
            throw new InvalidParameterException("INCORRECT PATIENT ID!");
        }
        return medicalClinicClient.getAvailableVisitsByDoctorId(doctorId);
    }

    public List<VisitDto> getAvailableVisitsBySpecializationAndDate(String specialization, LocalDate date) {
        if (specialization == null || specialization.trim().isEmpty()) {
            throw new InvalidParameterException("SPECIALIZATION CANNOT BE EMPTY");
        }
        if (date == null) {
            throw new InvalidParameterException("DATE CANNOT BE NULL");
        }
        if (date.isBefore(LocalDate.now())) {
            throw new InvalidParameterException("DATE CANNOT BE IN THE PAST");
        }
        return medicalClinicClient.getAvailableVisitsBySpecializationAndDate(specialization, date);
    }
}