package com.example.EJ2.models;

import lombok.*;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PersonInputDTO {

    private String user;
    private String password;
    private String name;
    private String surname = null;
    private String company_email;
    private String personal_email;
    private String city;
    private Boolean active = true;
    private String imagen_url = null;


}
