package com.alexlasota.medical_clinic_proxy.controller;

import com.alexlasota.medical_clinic_proxy.model.VisitDto;
import com.alexlasota.medical_clinic_proxy.service.ProxyVisitService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ProxyVisitControllerTest {

    @Mock
    ProxyVisitService proxyVisitService;

    ProxyVisitController proxyVisitController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        proxyVisitController = new ProxyVisitController(proxyVisitService);
    }


    @Test
    void getVisitsByPatientId() {
        Long patientId = 1L;
        List<VisitDto> expectedVisits = Arrays.asList(new VisitDto(), new VisitDto());
        when(proxyVisitService.getVisitsByPatientId(patientId)).thenReturn(expectedVisits);

        List<VisitDto> result = proxyVisitController.getVisitsByPatientId(patientId);

        assertEquals(expectedVisits, result);
        verify(proxyVisitService).getVisitsByPatientId(patientId);
    }
    @Test
    void assignPatientToVisit() {
        Long visitId = 1L;
        Long patientId = 2L;
        VisitDto expectedVisit = new VisitDto();
        when(proxyVisitService.assignPatientToVisit(visitId, patientId)).thenReturn(expectedVisit);

        VisitDto result = proxyVisitController.assignPatientToVisit(visitId, patientId);

        assertEquals(expectedVisit, result);
        verify(proxyVisitService).assignPatientToVisit(visitId, patientId);
    }

    @Test
    void getAvailableVisitsByDoctorId() {
        Long doctorId = 1L;
        List<VisitDto> expectedVisits = Arrays.asList(new VisitDto(), new VisitDto());
        when(proxyVisitService.getAvailableVisitsByDoctorId(doctorId)).thenReturn(expectedVisits);

        List<VisitDto> result = proxyVisitController.getAvailableVisitsByDoctorId(doctorId);

        assertEquals(expectedVisits, result);
        verify(proxyVisitService).getAvailableVisitsByDoctorId(doctorId);
    }

    @Test
    void getAvailableVisitsBySpecializationAndDate() {
        String specialization = "cardiology";
        LocalDate date = LocalDate.now();
        List<VisitDto> expectedVisits = Arrays.asList(new VisitDto(), new VisitDto());
        when(proxyVisitService.getAvailableVisitsBySpecializationAndDate(specialization, date)).thenReturn(expectedVisits);

        List<VisitDto> result = proxyVisitController.getAvailableVisitsBySpecializationAndDate(specialization, date);

        assertEquals(expectedVisits, result);
        verify(proxyVisitService).getAvailableVisitsBySpecializationAndDate(specialization, date);
    }
}