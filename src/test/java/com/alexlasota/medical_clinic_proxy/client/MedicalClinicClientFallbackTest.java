package com.alexlasota.medical_clinic_proxy.client;

import com.alexlasota.medical_clinic_proxy.model.VisitDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MedicalClinicClientFallbackTest {

    private MedicalClinicFallback medicalClinicFallback;

    @BeforeEach
    void setUp() {
        medicalClinicFallback = new MedicalClinicFallback();
    }

    @Test
    void getVisitsByPatientId_shouldReturnEmptyList() {
        List<VisitDto> result = medicalClinicFallback.getVisitsByPatientId(1L);
        assertTrue(result.isEmpty());
    }

    @Test
    void assignPatientToVisit_shouldReturnNull() {
        VisitDto result = medicalClinicFallback.assignPatientToVisit(1L, 2L);
        assertNull(result);
    }

    @Test
    void getAvailableVisitsByDoctorId_shouldReturnEmptyList() {
        List<VisitDto> result = medicalClinicFallback.getAvailableVisitsByDoctorId(1L);
        assertTrue(result.isEmpty());
    }

    @Test
    void getAvailableVisitsBySpecializationAndDate_shouldReturnEmptyList() {
        LocalDate testDate = LocalDate.now();
        List<VisitDto> result = medicalClinicFallback.getAvailableVisitsBySpecializationAndDate("cardiology", testDate);
        assertTrue(result.isEmpty());
    }
}