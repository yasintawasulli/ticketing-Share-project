package com.cydeo.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TaskDTO {

    private Long id;
    private ProjectDTO project;
    private UserDTO assignEmployee;
    private String taskSubject;
    private String taskDetail;
    private LocalDate taskAssignedDate;




}
