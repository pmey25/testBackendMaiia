package com.maiia.pro.repository;

import com.maiia.pro.entity.Practitioner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PractitionerRepository extends CrudRepository<Practitioner, String> {
    List<Practitioner> findAll();

    Optional<Practitioner> findById(Integer id);
}
