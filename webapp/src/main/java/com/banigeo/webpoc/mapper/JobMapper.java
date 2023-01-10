package com.banigeo.webpoc.mapper;

import com.banigeo.webpoc.dto.job.JobRequest;
import com.banigeo.webpoc.dto.job.JobResponse;
import com.banigeo.webpoc.model.Job;
import com.banigeo.webpoc.model.JobTitle;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class JobMapper {

    public JobResponse fromEntityToResponse(Job entity) {
        return JobResponse.builder()
                .id(entity.getJobId())
                .title(entity.getJobTitle().toString())
                .min(entity.getMinSalary())
                .max(entity.getMaxSalary())
                .build();
    }

    public Job fromResponseToEntity(JobResponse response) {
        return Job.builder()
                .jobId(response.getId())
                .jobTitle(JobTitle.valueOf(response.getTitle()))
                .maxSalary(response.getMax())
                .minSalary(response.getMin())
                .build();
    }

    public Job fromRequestToEntity(JobRequest request) {
        return Job.builder()
                .jobTitle(JobTitle.valueOf(request.getTitle()))
                .maxSalary(request.getMax())
                .minSalary(request.getMin())
                .build();
    }

}
