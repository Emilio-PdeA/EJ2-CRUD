package com.example.EJ2.controllers;

import com.example.EJ2.models.Person;
import com.example.EJ2.models.PersonInputDTO;
import com.example.EJ2.models.PersonOutputDTO;
import com.example.EJ2.services.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class PersonController {

    @Autowired
    PersonServices personServices;

    @GetMapping("listUsers")
    public List<PersonOutputDTO> getListUsers(){return personServices.listUsers();}

    @GetMapping("{id}")
    public ResponseEntity getPersonaID(@PathVariable Integer id){
        try{
            return new ResponseEntity(personServices.findUserId(id), HttpStatus.OK);
        }catch (EntityNotFoundException e){
            return new ResponseEntity("{\"debugError\":\"" +e.getMessage() + "\"}" , HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("user/{user}")
    public ResponseEntity getPersonaUser(@PathVariable String user){
        try{
            return new ResponseEntity(personServices.findByUser(user),HttpStatus.OK);
        }catch (EntityNotFoundException e){
            return new ResponseEntity("{\"debugError\":\"" +e.getMessage() + "\"}" , HttpStatus.BAD_REQUEST);
        }

    }

    @PostMapping("addPerson")
    public ResponseEntity addPerson(@RequestBody PersonInputDTO personInputDTO) throws Exception{
        try{
            return new ResponseEntity(personServices.addUser(personInputDTO),HttpStatus.OK) ;
        }catch (Exception e){
            return new ResponseEntity("{\"debugError\":\"" +e.getMessage() + "\"}" , HttpStatus.BAD_REQUEST);
        }
    }



}
