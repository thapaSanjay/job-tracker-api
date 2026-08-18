package com.sanjay.jobtracker.controller;

import com.sanjay.jobtracker.model.JobApplication;
import com.sanjay.jobtracker.service.JobApplicationService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobApplicationController {
    private final JobApplicationService jobApplicationService;

    public JobApplicationController(JobApplicationService jobApplicationService) {
        this.jobApplicationService = jobApplicationService;
    }

    @PostMapping
    public JobApplication addJobApplication(@Valid @RequestBody JobApplication jobApplication) {
        return jobApplicationService.addJobApplication(jobApplication);
    }

    @GetMapping
    public List<JobApplication> getAllJobApplications() {
        return jobApplicationService.getAllJobApplications();
    }

    @GetMapping("/{id}")
    public JobApplication getJobApplicationById(@PathVariable int id) {
        return jobApplicationService.getJobApplicationById(id);
    }

    @PutMapping("/{id}")
    public JobApplication updateJobApplication(
            @PathVariable int id,
            @Valid @RequestBody JobApplication jobApplication
    ) {
        return jobApplicationService.updateJobApplication(id, jobApplication);
    }

    @DeleteMapping("/{id}")
    public void deleteJobApplication(@PathVariable int id) {
        jobApplicationService.deleteJobApplication(id);
    }

    @GetMapping("/status/{status}")
    public List<JobApplication> getJobApplicationsByStatus(@PathVariable String status) {
        return jobApplicationService.getJobApplicationsByStatus(status);
    }
}
