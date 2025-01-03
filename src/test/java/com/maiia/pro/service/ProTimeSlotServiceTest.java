package com.maiia.pro.service;

import com.maiia.pro.entity.TimeSlot;
import com.maiia.pro.fabrique.EntityFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
@SpringBootTest
@ActiveProfiles("test")
class ProTimeSlotServiceTest {
    @Autowired
    private ProTimeSlotService proTimeSlotService;

    @Test
    void findByPractitionerId() {
        proTimeSlotService.save(EntityFactory.createTimeSlot(1, LocalDateTime.of(2025,1,2,9,0),LocalDateTime.of(2025,1,2,9,0).plusMinutes(15)));
        TimeSlot timeSlotBdd = proTimeSlotService.findByPractitionerId(1).get(0);
        assertEquals(LocalDateTime.of(2025,1,2,9,0),timeSlotBdd.getStartDate());
        assertEquals(LocalDateTime.of(2025,1,2,9,0).plusMinutes(15),timeSlotBdd.getEndDate());
        List<TimeSlot> timeSlots = List.of(EntityFactory.createTimeSlot(2, LocalDateTime.of(2025,1,2,9,0),LocalDateTime.of(2025,1,2,9,0).plusMinutes(30)),
                EntityFactory.createTimeSlot(2, LocalDateTime.of(2025,1,2,9,0),LocalDateTime.of(2025,1,2,9,0).plusMinutes(45)));
        proTimeSlotService.saveAll(timeSlots);
        List<TimeSlot> timeSlotListBdd = proTimeSlotService.findByPractitionerId(2);
        assertEquals(LocalDateTime.of(2025,1,2,9,0).plusMinutes(30),timeSlotListBdd.get(0).getEndDate());
        assertEquals(LocalDateTime.of(2025,1,2,9,0).plusMinutes(45),timeSlotListBdd.get(1).getEndDate());
    }
}