package com.example.EJ2.infrastructure.controller;

import com.example.EJ2.domain.exception.PersonNotFoundException;
import com.example.EJ2.domain.exception.PersonUnprocessableException;
import com.example.EJ2.infrastructure.controller.dto.input.PersonInputDTO;
import com.example.EJ2.infrastructure.controller.dto.output.PersonOutputDTO;
import com.example.EJ2.application.services.PersonServicesInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("EJ2")
public class PersonController {

    @Autowired
    PersonServicesInter personServicesInter;

    @GetMapping("listUsers")
    public List<PersonOutputDTO> getListUsers(){return personServicesInter.listUsers();}

    @GetMapping("{id}")
    public PersonOutputDTO getPersonaID(@PathVariable Integer id){
        PersonOutputDTO person = null;
        person=personServicesInter.findUserId(id);
        return person;

    }

    @GetMapping("user/{user}")
    public PersonOutputDTO getPersonaUser(@PathVariable String user){
        PersonOutputDTO person = null;
        person=personServicesInter.findByUser(user);
        return person;
    }

    @PostMapping("addPerson")
    public PersonOutputDTO addPerson(@RequestBody PersonInputDTO personInputDTO) throws PersonUnprocessableException {
        PersonOutputDTO person = null;
        person=personServicesInter.addUser(personInputDTO);
        return person;
    }



}
