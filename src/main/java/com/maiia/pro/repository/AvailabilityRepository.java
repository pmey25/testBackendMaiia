package com.maiia.pro.repository;

import com.maiia.pro.entity.Availability;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvailabilityRepository extends CrudRepository<Availability, String> {

}
