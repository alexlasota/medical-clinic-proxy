package com.alexlasota.medical_clinic_proxy.client;

import com.alexlasota.medical_clinic_proxy.model.VisitDto;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@Component
public class MedicalClinicFallback implements MedicalClinicClient {

    @Override
    public List<VisitDto> getVisitsByPatientId(Long patientId) {
        return Collections.emptyList();
    }

    @Override
    public VisitDto assignPatientToVisit(Long visitId, Long patientId) {
        return null;
    }

    @Override
    public List<VisitDto> getAvailableVisitsByDoctorId(Long doctorId) {
        return Collections.emptyList();
    }

    @Override
    public List<VisitDto> getAvailableVisitsBySpecializationAndDate(String specialization, LocalDate date) {
        return Collections.emptyList();
    }
}