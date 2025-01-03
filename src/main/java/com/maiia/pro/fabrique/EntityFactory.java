package com.maiia.pro.fabrique;

import com.maiia.pro.entity.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class EntityFactory {

    public static TimeSlot createTimeSlot(final Integer practitionerId, final LocalDateTime startDate, final LocalDateTime endDate) {
        return TimeSlot.builder()
                .practitionerId(practitionerId)
                .startDate(startDate)
                .endDate(endDate)
                .build();
    }

    public static Appointment createAppointment(final Integer practitionerId, final Integer patientId, final LocalDateTime startDate, final LocalDateTime endDate) {
        return Appointment.builder()
                .practitionerId(practitionerId).
                patientId(patientId).
                startDate(startDate).
                endDate(endDate).build();
    }

    public static Practitioner createPractitioner(final String firstName, final String lastName, final String speciality) {
        return Practitioner.builder().
                firstName(firstName).
                lastName(lastName).
                speciality(speciality).build();
    }

    public static Patient createPatient(final String firstName, final String lastName, final LocalDate birthDate) {
        return Patient.builder().
                lastName(lastName).
                firstName(firstName).birthDate(birthDate).build();

        }
    }
