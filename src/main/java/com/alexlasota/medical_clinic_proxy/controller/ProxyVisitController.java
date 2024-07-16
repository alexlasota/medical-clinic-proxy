package com.alexlasota.medical_clinic_proxy.controller;

import com.alexlasota.medical_clinic_proxy.model.VisitDto;
import com.alexlasota.medical_clinic_proxy.service.ProxyVisitService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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

    @RequestMapping(value = "/visits/{visitId}/patients/{patientId}", method = RequestMethod.PATCH)
    public VisitDto assignPatientToVisit(@PathVariable Long visitId, @PathVariable Long patientId) {
        return proxyVisitService.assignPatientToVisit(visitId, patientId);
    }

    @GetMapping("/doctor/{doctorId}/available")
    public List<VisitDto> getAvailableVisitsByDoctorId(@PathVariable Long doctorId) {
        return proxyVisitService.getAvailableVisitsByDoctorId(doctorId);
    }

    @GetMapping("/specialization/{specialization}/date")
    public List<VisitDto> getAvailableVisitsBySpecializationAndDate(@PathVariable String specialization, @RequestParam LocalDate date) {
        return proxyVisitService.getAvailableVisitsBySpecializationAndDate(specialization, date);
    }
}