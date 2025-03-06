package ru.netology.hibernateproj;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Repository
@Transactional
public interface PersonsRepository extends JpaRepository<Persons, Long> {
    List<Persons> getPersonsByCityOfLiving(String cityOfLiving);
}