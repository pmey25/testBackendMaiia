package com.maiia.pro.service;

import com.maiia.pro.entity.TimeSlot;
import com.maiia.pro.repository.TimeSlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProTimeSlotService {
    @Autowired
    private TimeSlotRepository timeSlotRepository;

    public List<TimeSlot> findByPractitionerId(final Integer practitionerId) {
        return timeSlotRepository.findByPractitionerId(practitionerId);
    }
    @Transactional
    public void saveAll(final List<TimeSlot> timeSlots) {
        timeSlotRepository.saveAll(timeSlots);
    }

    @Transactional
    public void save(final TimeSlot timeSlot) {
        timeSlotRepository.save(timeSlot);
    }
}
