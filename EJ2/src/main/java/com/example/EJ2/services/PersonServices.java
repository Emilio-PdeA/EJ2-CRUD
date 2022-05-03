package com.example.EJ2.services;

import com.example.EJ2.models.Person;
import com.example.EJ2.models.PersonInputDTO;
import com.example.EJ2.models.PersonOutputDTO;
import com.example.EJ2.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonServices {

    @Autowired
    PersonRepository personRepository;

    public PersonServices(){}


    public PersonOutputDTO addUser(PersonInputDTO personInputDTO) throws Exception{
            Optional<Person> person = Optional.of(new Person(personInputDTO));
            personRepository.save(person.get());
            PersonOutputDTO personOutputDTO = new PersonOutputDTO(person.get());
            return personOutputDTO;
    }

    public PersonOutputDTO findUserId(Integer id){
        Optional<Person> person = Optional.ofNullable(personRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User " + id + " not found.")));
        return new PersonOutputDTO(person.get());
    }

    public List<PersonOutputDTO> listUsers(){
        List <Person> people = personRepository.findAll();
        return people.stream().map(pp->new PersonOutputDTO(pp)).collect(Collectors.toList());
    }

    public PersonOutputDTO findByUser(String user){
        Optional<Person> person = Optional.ofNullable(personRepository.findByUser(user).orElseThrow(()->new EntityNotFoundException("User " + user + " does not exist.")));
        return new PersonOutputDTO(person.get());
    }




}
