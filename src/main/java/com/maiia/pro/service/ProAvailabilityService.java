package com.maiia.pro.service;

import com.maiia.pro.entity.Appointment;
import com.maiia.pro.entity.Availability;
import com.maiia.pro.entity.TimeSlot;
import com.maiia.pro.repository.AvailabilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProAvailabilityService {

    public static final int QUINZE = 15;
    @Autowired
    private AvailabilityRepository availabilityRepository;

    @Autowired
    private ProTimeSlotService proTimeSlotService;
    @Autowired
    private ProAppointmentService proAppointmentService;

    @Transactional
    public List<Availability> findByPractitionerId(Integer practitionerId) {
        return generateAvailabilities(practitionerId);
    }

    public List<Availability> generateAvailabilities(final Integer practitionerId) {
        List<Availability> availabilityList = new ArrayList<>();
        proTimeSlotService.findByPractitionerId(practitionerId).forEach(ts -> availabilityList.addAll(generateAvailabilitiesFromTimeSlot(ts, practitionerId)));
        saveAvailability(availabilityList);
        return availabilityList;
    }

    private List<Appointment> getAppoitments(Integer practitionerId) {
        return  proAppointmentService.findByPractitionerId(practitionerId) ;
    }

    private void saveAvailability(final List<Availability> availabilities) {
        availabilityRepository.saveAll(availabilities);
    }

    private List<Availability> generateAvailabilitiesFromTimeSlot(final TimeSlot timeSlot, final Integer practitionerId) {
        List<Availability> availabilities = new ArrayList<>();
        List<Appointment> appointmentList = getAppoitments(practitionerId);

        LocalDateTime start = timeSlot.getStartDate();
        LocalDateTime end = timeSlot.getEndDate();

        while (start.isBefore(end)) {
            LocalDateTime nextStart = start.plusMinutes(QUINZE);
            Availability availability = Availability.builder().startDate(start).endDate(nextStart).practitionerId(timeSlot.getPractitionerId()).build();

            availabilities.add(availability);
            start = nextStart;
        }
        return availabilities.stream()
                .filter(availability -> appointmentList.stream()
                        .noneMatch(appointment ->
                                appointment.getStartDate().isBefore(availability.getEndDate()) &&
                                        appointment.getEndDate().isAfter(availability.getStartDate())))
                .collect(Collectors.toList());
    }

    public List<Availability> findAll() {
        return (List<Availability>) availabilityRepository.findAll();
    }
}
