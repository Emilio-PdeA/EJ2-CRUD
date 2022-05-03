package com.example.EJ2.repositories;

import com.example.EJ2.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person,Integer> {
    List<Person> findAll();
    Optional<Person> findByUser(String user);
}
