package com.banigeo.webpoc.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity(name = "jobs")
@Data
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer jobId;

    @NotNull
    @Enumerated(value = EnumType.STRING)
    private JobTitle jobTitle;

    @NotNull
    @Min(0)
    private Double minSalary;

    @NotNull
    @Min(0)
    private Double maxSalary;


    public Job(JobTitle jobTitle, Double minSalary, Double maxSalary) {
        this.jobTitle = jobTitle;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
    }
}