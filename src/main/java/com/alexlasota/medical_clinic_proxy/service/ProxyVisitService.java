package com.alexlasota.medical_clinic_proxy.service;

import com.alexlasota.medical_clinic_proxy.client.MedicalClinicClient;
import com.alexlasota.medical_clinic_proxy.model.VisitDto;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProxyVisitService {

    private final MedicalClinicClient medicalClinicClient;

    public ProxyVisitService(MedicalClinicClient medicalClinicClient) {
        this.medicalClinicClient = medicalClinicClient;
    }

    public List<VisitDto> getVisitsByPatientId(Long patientId) {
        return medicalClinicClient.getVisitsByPatientId(patientId);
    }

    public VisitDto assignPatientToVisit(@PathVariable Long visitId, @PathVariable Long patientId) {
        return medicalClinicClient.assignPatientToVisit(visitId, patientId);
    }

    public List<VisitDto> getAvailableVisitsByDoctorId(Long doctorId) {
        return medicalClinicClient.getAvailableVisitsByDoctorId(doctorId);
    }

    public List<VisitDto> getAvailableVisitsBySpecializationAndDate(String specialization, LocalDateTime startDate, LocalDateTime endDate) {
        return medicalClinicClient.getAvailableVisitsBySpecializationAndDate(specialization, startDate, endDate);
    }
}