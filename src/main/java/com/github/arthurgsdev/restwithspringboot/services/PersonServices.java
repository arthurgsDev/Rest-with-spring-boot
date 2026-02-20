package com.github.arthurgsdev.restwithspringboot.services;

import com.github.arthurgsdev.restwithspringboot.model.Person;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();

    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    public Person findById(String id) {
        logger.info("Finding one person!");

        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Leandro");
        person.setLastName("Rodrigo");
        person.setAddress("Diamante - Minas Gerais");
        person.setGender("M");
        return person;
    }
}