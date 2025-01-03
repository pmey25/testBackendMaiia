package com.maiia.pro.service;

import com.maiia.pro.entity.Practitioner;
import com.maiia.pro.fabrique.EntityFactory;
import com.maiia.pro.repository.PractitionerRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@ActiveProfiles("test")
class ProPractitionerServiceTest {
@Autowired
private ProPractitionerService proPractitionerService;

@Autowired
private PractitionerRepository practitionerRepository;

    @Test
    void find() {
        Practitioner practitioner = proPractitionerService.save(EntityFactory.createPractitioner("firstName", "lastName", "speciality"));
        Optional<Practitioner> practitionerBdd = proPractitionerService.find(practitioner.getId());
        Practitioner practitionerPresent = practitionerBdd.orElseThrow(() -> new AssertionError("Practitioner should be present"));
        assertEquals("firstName", practitionerPresent.getFirstName());
        assertEquals("lastName", practitionerPresent.getLastName());
        assertEquals("speciality", practitionerPresent.getSpeciality());

    }

    @Test
    void findAll() {
        Practitioner practitioner = EntityFactory.createPractitioner("firstName", "lastName", "speciality");
        Practitioner practitioner2 = EntityFactory.createPractitioner("firstName", "lastName", "speciality");
        Practitioner practitioner3 = EntityFactory.createPractitioner("firstName", "lastName", "speciality");
        proPractitionerService.save(practitioner);
        proPractitionerService.save(practitioner2);
        proPractitionerService.save(practitioner3);
        assertEquals(3, proPractitionerService.findAll().size());
    }

    @AfterEach
    void cleanUp() {
        practitionerRepository.deleteAll();
    }
}