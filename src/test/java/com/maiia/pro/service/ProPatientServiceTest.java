package com.maiia.pro.service;

import com.maiia.pro.entity.Patient;
import com.maiia.pro.fabrique.EntityFactory;
import com.maiia.pro.repository.PatientRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@ActiveProfiles("test")
class ProPatientServiceTest {
    @Autowired
    ProPatientService proPatientService;

    @Autowired
    PatientRepository patientRepository;

    @Test
    void findAll() {
        Patient patient = EntityFactory.createPatient("firstName", "lastName", LocalDate.of(2025,1,1));
        Patient patient2 = EntityFactory.createPatient("firstName", "lastName", LocalDate.of(2025,2,1));
        proPatientService.save(patient);
        proPatientService.save(patient2);
        List<Patient> patients = proPatientService.findAll();
        assertEquals(2, patients.size());
    }

    @AfterEach
    void cleanUp() {
        patientRepository.deleteAll();
    }

}