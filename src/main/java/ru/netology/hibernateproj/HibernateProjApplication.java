package ru.netology.hibernateproj;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;


@SpringBootApplication
public class HibernateProjApplication implements CommandLineRunner {
    @PersistenceContext
    private EntityManager entityManager;

    public static void main(String[] args) {
        SpringApplication.run(HibernateProjApplication.class, args);
    }

    @Transactional
    @Override
    public void run(String... args) throws Exception {
        Persons person = new Persons();
        person.setName("Jack");
        person.setAge(25);
        person.setCityOfLiving("San Francisco");
        person.setSurname("Nikolson");
        person.setPhoneNumber("893256654674");
        entityManager.persist(person);

        Persons person2 = new Persons();
        person2.setName("Nick");
        person2.setSurname("Brown");
        person2.setAge(36);
        person2.setCityOfLiving("Moscow");
        person2.setPhoneNumber("8932566474");
        entityManager.persist(person2);

        Persons entity = entityManager.find(Persons.class, 1L);
        System.out.println(entity);

    }
}
