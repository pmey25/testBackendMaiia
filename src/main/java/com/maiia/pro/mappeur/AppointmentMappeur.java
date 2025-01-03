package com.maiia.pro.mappeur;

import com.maiia.pro.controller.AppointmentDTO;
import com.maiia.pro.entity.Appointment;
import com.maiia.pro.fabrique.EntityFactory;
import org.springframework.stereotype.Component;

@Component
public class AppointmentMappeur {

public Appointment transformeAppointmentDtoToAppoitmentEntity(final AppointmentDTO appointmentDTO) {
    return EntityFactory.createAppointment(appointmentDTO.getPractitionerId(),appointmentDTO.getPatientId(),appointmentDTO.getStartDate(), appointmentDTO.getEndDate());
}

}
