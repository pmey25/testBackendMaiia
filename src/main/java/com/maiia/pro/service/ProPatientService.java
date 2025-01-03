package com.maiia.pro.service;

import com.maiia.pro.entity.Patient;
import com.maiia.pro.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProPatientService {
    @Autowired
    private PatientRepository patientRepository;

    public List<Patient> findAll() {
        return patientRepository.findAll();
    }

    @Transactional
    public void save(Patient patient) {
        patientRepository.save(patient);
    }
}
