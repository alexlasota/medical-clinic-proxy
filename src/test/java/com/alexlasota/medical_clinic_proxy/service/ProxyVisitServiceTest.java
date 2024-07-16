package com.alexlasota.medical_clinic_proxy.service;

import com.alexlasota.medical_clinic_proxy.client.MedicalClinicClient;
import com.alexlasota.medical_clinic_proxy.model.VisitDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class ProxyVisitServiceTest {

    @Mock
    private MedicalClinicClient medicalClinicClient;

    private ProxyVisitService proxyVisitService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        proxyVisitService = new ProxyVisitService(medicalClinicClient);
    }

    @Test
    void getVisitsByPatientId() {
        Long patientId = 1L;
        List<VisitDto> expectedVisits = Arrays.asList(new VisitDto(), new VisitDto());
        when(medicalClinicClient.getVisitsByPatientId(patientId)).thenReturn(expectedVisits);

        List<VisitDto> result = proxyVisitService.getVisitsByPatientId(patientId);

        assertEquals(expectedVisits, result);
        verify(medicalClinicClient).getVisitsByPatientId(patientId);
    }

    @Test
    void assignPatientToVisit() {
        Long visitId = 1L;
        Long patientId = 2L;
        VisitDto expectedVisit = new VisitDto();
        when(medicalClinicClient.assignPatientToVisit(visitId, patientId)).thenReturn(expectedVisit);

        VisitDto result = proxyVisitService.assignPatientToVisit(visitId, patientId);

        assertEquals(expectedVisit, result);
        verify(medicalClinicClient).assignPatientToVisit(visitId, patientId);
    }

    @Test
    void getAvailableVisitsByDoctorId() {
        Long doctorId = 1L;
        List<VisitDto> expectedVisits = Arrays.asList(new VisitDto(), new VisitDto());
        when(medicalClinicClient.getAvailableVisitsByDoctorId(doctorId)).thenReturn(expectedVisits);

        List<VisitDto> result = proxyVisitService.getAvailableVisitsByDoctorId(doctorId);

        assertEquals(expectedVisits, result);
        verify(medicalClinicClient).getAvailableVisitsByDoctorId(doctorId);
    }

    @Test
    void getAvailableVisitsBySpecializationAndDate() {
        String specialization = "cardiology";
        LocalDate date = LocalDate.now();
        List<VisitDto> expectedVisits = Arrays.asList(new VisitDto(), new VisitDto());
        when(medicalClinicClient.getAvailableVisitsBySpecializationAndDate(specialization, date)).thenReturn(expectedVisits);

        List<VisitDto> result = proxyVisitService.getAvailableVisitsBySpecializationAndDate(specialization, date);

        assertEquals(expectedVisits, result);
        verify(medicalClinicClient).getAvailableVisitsBySpecializationAndDate(specialization, date);
    }
}