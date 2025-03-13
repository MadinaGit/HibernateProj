package ru.netology.hibernateproj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/persons")
public class PersonsController {

    private final PersonsRepository personsRepository;

    @Autowired
    public PersonsController(PersonsRepository personsRepository) {
        this.personsRepository = personsRepository;
    }

    @GetMapping("/by-city")
    public ResponseEntity<List<Persons>> getPersonsByCity(@RequestParam String city) {
        List<Persons> persons = personsRepository.findByCityOfLiving(city);
        if (persons.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(persons);
    }

    @GetMapping("/by-age")
    public ResponseEntity<List<Persons>> getPersonsAgeLessThan(@RequestParam int age) {
        List<Persons> persons = personsRepository.findByAgeLessThanOrderByAgeAsc(age);
        if (persons.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(persons);
    }

    @GetMapping("/by-name-and-surname")
    public ResponseEntity<Persons> getPersonsByNameAndSurname(@RequestParam String name, @RequestParam String surname) {
        Optional<Persons> persons = personsRepository.findByNameAndSurname(name, surname);
        return persons.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}


