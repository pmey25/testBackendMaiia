package com.maiia.pro.service;

import com.maiia.pro.controller.AppointmentDTO;
import com.maiia.pro.entity.Appointment;
import com.maiia.pro.mappeur.AppointmentMappeur;
import com.maiia.pro.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProAppointmentService {
    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private AppointmentMappeur appointmentMappeur;

    public List<Appointment> findAll() {
        return appointmentRepository.findAll();
    }

    public List<Appointment> findByPractitionerId(final Integer practitionerId) {
        return appointmentRepository.findByPractitionerId(practitionerId);
    }

    public Appointment save(final AppointmentDTO appointment) {
        return appointmentRepository.save(appointmentMappeur.transformeAppointmentDtoToAppoitmentEntity(appointment));
    }
}
