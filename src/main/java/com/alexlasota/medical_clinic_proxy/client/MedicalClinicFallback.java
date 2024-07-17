package com.alexlasota.medical_clinic_proxy.client;

import com.alexlasota.medical_clinic_proxy.exceptions.MedicalClinicServiceException;
import com.alexlasota.medical_clinic_proxy.model.VisitDto;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@Component
public class MedicalClinicFallback implements MedicalClinicClient {

    @Override
    public List<VisitDto> getVisitsByPatientId(Long patientId) {
        throw new MedicalClinicServiceException("We are currently unable to show you your visits. Please try again later.");
    }

    @Override
    public VisitDto assignPatientToVisit(Long visitId, Long patientId) {
        throw new MedicalClinicServiceException("We are currently unable to assign you to the visit. Please try again later.");
    }

    @Override
    public List<VisitDto> getAvailableVisitsByDoctorId(Long doctorId) {
        throw new MedicalClinicServiceException("We are currently unable to show available visits for the doctor. Please try again later.");
    }

    @Override
    public List<VisitDto> getAvailableVisitsBySpecializationAndDate(String specialization, LocalDate date) {
        throw new MedicalClinicServiceException("We are currently unable to show available visits by specialization and date. Please try again later.");
    }
}