package com.maiia.pro;

import com.github.javafaker.Faker;
import com.maiia.pro.entity.Practitioner;
import com.maiia.pro.entity.TimeSlot;

import java.time.LocalDateTime;
import java.util.Locale;

public class EntityFactory {
    static final Faker faker = new Faker(Locale.FRANCE);

    public static Practitioner createPractitioner() {
        return Practitioner.builder()
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .build();
    }

    public static TimeSlot createTimeSlot(Integer practitionerId, LocalDateTime startDate, LocalDateTime endDate) {
        return TimeSlot.builder()
                .practitionerId(practitionerId)
                .startDate(startDate)
                .endDate(endDate)
                .build();
    }

}
