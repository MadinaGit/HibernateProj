package ru.netology.hibernateproj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
    @RequestMapping
    public class PersonsController {

        private final PersonsRepository personsRepository;

        @Autowired
        public PersonsController(PersonsRepository personsRepository) {
            this.personsRepository = personsRepository;
        }

    @GetMapping("/persons/by-city")
    public ResponseEntity<List<Persons>> getPersonsByCity(@RequestParam String city) {
        List<Persons> persons = personsRepository.getPersonsByCityOfLiving(city);
        return ResponseEntity.ok(persons);
    }
    }


