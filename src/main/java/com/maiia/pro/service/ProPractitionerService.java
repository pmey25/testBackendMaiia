package com.maiia.pro.service;

import com.maiia.pro.entity.Practitioner;
import com.maiia.pro.repository.PractitionerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProPractitionerService {
    @Autowired
    private PractitionerRepository practitionerRepository;

    public Optional<Practitioner> find(final Integer practitionerId) {
        return practitionerRepository.findById(practitionerId);
    }

    public List<Practitioner> findAll() {
        return practitionerRepository.findAll();
    }

    @Transactional
    public Practitioner save(Practitioner practitioner) {
         return practitionerRepository.save(practitioner);
    }
}
