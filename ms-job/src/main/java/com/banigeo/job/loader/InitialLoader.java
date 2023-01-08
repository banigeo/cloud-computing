package com.banigeo.job.loader;

import com.banigeo.job.model.Job;
import com.banigeo.job.model.JobTitle;
import com.banigeo.job.repository.JobHistoryRepository;
import com.banigeo.job.repository.JobRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
@Component
public class InitialLoader implements CommandLineRunner {
    JobRepository jobRepository;
    JobHistoryRepository jobHistoryRepository;

    @Override
    public void run(String... args) throws Exception {
        List<Job> jobs = Arrays.asList(
                new Job(JobTitle.Programmer, 4000d, 10000d),
                new Job(JobTitle.Marketing_Manager, 9000d, 15000d),
                new Job(JobTitle.Human_Resources_Representative, 4000d, 9000d),
                new Job(JobTitle.Public_Relations_Representative, 4500d, 10500d));

        jobRepository.saveAll(jobs);
    }
}