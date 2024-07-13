package com.alexlasota.medical_clinic_proxy.controller;

import com.alexlasota.medical_clinic_proxy.model.VisitDto;
import com.alexlasota.medical_clinic_proxy.service.ProxyVisitService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/proxy/visits")
public class ProxyVisitController {

    private final ProxyVisitService proxyVisitService;

    public ProxyVisitController(ProxyVisitService proxyVisitService) {
        this.proxyVisitService = proxyVisitService;
    }

    @GetMapping("/patient/{patientId}")
    public List<VisitDto> getVisitsByPatientId(@PathVariable Long patientId) {
        return proxyVisitService.getVisitsByPatientId(patientId);
    }

    @PatchMapping("/{visitId}/patients/{patientId}")
    public VisitDto assignPatientToVisit(@PathVariable Long visitId, @PathVariable Long patientId) {
        return proxyVisitService.assignPatientToVisit(visitId, patientId);
    }

    @GetMapping("/doctor/{doctorId}/available")
    public List<VisitDto> getAvailableVisitsByDoctorId(@PathVariable Long doctorId) {
        return proxyVisitService.getAvailableVisitsByDoctorId(doctorId);
    }

    @GetMapping("/specialization/{specialization}/date")
    public List<VisitDto> getAvailableVisitsBySpecializationAndDate(@PathVariable String specialization, @RequestParam LocalDateTime startDate, @RequestParam LocalDateTime endDate) {
        return proxyVisitService.getAvailableVisitsBySpecializationAndDate(specialization, startDate, endDate);
    }
}