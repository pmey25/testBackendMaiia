package com.maiia.pro.service;

import com.maiia.pro.controller.AppointmentDTO;
import com.maiia.pro.entity.Appointment;
import com.maiia.pro.repository.AppointmentRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
@SpringBootTest
@ActiveProfiles("test")
class ProAppointmentServiceTest {
    @Autowired
    private ProAppointmentService proAppointmentService;
    @Autowired
    private AppointmentRepository appointmentRepository;

    @Test
    void findAll() {
        AppointmentDTO appointmentDTO = AppointmentDTO.builder().practitionerId(1).patientId(1).
                startDate(LocalDateTime.of(2025, 1, 1, 1, 1))
                .endDate(LocalDateTime.of(2025, 1, 1, 1, 1).plusMinutes(15)).build();

        proAppointmentService.save(appointmentDTO);

        AppointmentDTO appointmentDTO2 = AppointmentDTO.builder().practitionerId(1).patientId(1).
                startDate(LocalDateTime.of(2025, 1, 1, 1, 1))
                .endDate(LocalDateTime.of(2025, 1, 1, 1, 1).plusMinutes(30)).build();
        proAppointmentService.save(appointmentDTO2);
        List<Appointment> appointments = proAppointmentService.findAll();
        assertEquals(2, appointments.size());
    }

    @Test
    void findByPractitionerId() {
        AppointmentDTO appointmentDTO = AppointmentDTO.builder().practitionerId(2).patientId(1).
                startDate(LocalDateTime.of(2025, 1, 1, 1, 1))
                .endDate(LocalDateTime.of(2025, 1, 1, 1, 1).plusMinutes(15)).build();

        proAppointmentService.save(appointmentDTO);
        List<Appointment> appointments = proAppointmentService.findByPractitionerId(2);
        assertEquals(1, appointments.size());

        }
    @AfterEach
    void cleanUp() {
        appointmentRepository.deleteAll();
    }

}