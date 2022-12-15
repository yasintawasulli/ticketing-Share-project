package com.cydeo.entity;

import com.cydeo.enums.Status;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "projects")
public class Project extends BaseEntity{

    @Column(unique = true)
    private String projectCode;

    private String projectName;

    @ManyToOne
    @JoinColumn(name = "manager_id")
    private User assignManager;

    @Column(columnDefinition = "DATE")
    private LocalDate projectStartDate;

    @Column(columnDefinition = "DATE")
    private LocalDate projectEndDate;

    private String projectDetail;

    @Enumerated(EnumType.STRING)
    private Status projectStatus;





}
