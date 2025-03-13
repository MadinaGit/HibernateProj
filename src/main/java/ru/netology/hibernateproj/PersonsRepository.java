package ru.netology.hibernateproj;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface PersonsRepository extends JpaRepository<Persons, Long> {
    List<Persons> findByCityOfLiving(String cityOfLiving);

    List<Persons> findByAgeLessThanOrderByAgeAsc(int age);

    Optional<Persons> findByNameAndSurname(String name, String surname);

}