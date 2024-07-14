package com.alexlasota.medical_clinic_proxy.client;

import com.alexlasota.medical_clinic_proxy.model.VisitDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@FeignClient(name = "medical-clinic", url = "medical-clinic", fallback = MedicalClinicFallback.class)
public interface MedicalClinicClient {

    @GetMapping("/visits/patient/{patientId}")
    List<VisitDto> getVisitsByPatientId(@PathVariable Long patientId);

    @PatchMapping("/visits/{visitId}/patients/{patientId}")
    VisitDto assignPatientToVisit(@PathVariable Long visitId, @PathVariable Long patientId);

    @GetMapping("/visits/doctor/{doctorId}/available")
    List<VisitDto> getAvailableVisitsByDoctorId(@PathVariable Long doctorId);

    @GetMapping("/visits/specialization/{specialization}/date")
    List<VisitDto> getAvailableVisitsBySpecializationAndDate(
            @PathVariable String specialization,
            @RequestParam("startDate") LocalDateTime startDate,
            @RequestParam("endDate") LocalDateTime endDate);
}