package com.example.EJ2.application.services;

import com.example.EJ2.domain.exception.PersonUnprocessableException;
import com.example.EJ2.infrastructure.controller.dto.input.PersonInputDTO;
import com.example.EJ2.infrastructure.controller.dto.output.PersonOutputDTO;

import java.util.List;

public interface PersonServicesInter {

    public PersonOutputDTO addUser(PersonInputDTO personInputDTO) throws PersonUnprocessableException;

    public PersonOutputDTO findUserId(Integer id);

    public List<PersonOutputDTO> listUsers();

    public PersonOutputDTO findByUser(String user);





}
