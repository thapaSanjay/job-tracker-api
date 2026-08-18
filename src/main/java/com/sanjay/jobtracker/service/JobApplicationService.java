package com.sanjay.jobtracker.service;

import com.sanjay.jobtracker.dto.DashboardResponseDto;
import com.sanjay.jobtracker.exception.JobApplicationNotFoundException;
import com.sanjay.jobtracker.model.JobApplication;
import com.sanjay.jobtracker.repository.JobApplicationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobApplicationService {

    private final JobApplicationRepository jobApplicationRepository;

    public JobApplicationService(JobApplicationRepository jobApplicationRepository) {
        this.jobApplicationRepository = jobApplicationRepository;
    }

    public JobApplication addJobApplication(JobApplication jobApplication) {
        return jobApplicationRepository.save(jobApplication);
    }

    public List<JobApplication> getAllJobApplications() {
        return jobApplicationRepository.findAll();
    }

    public JobApplication getJobApplicationById(int id) {
        return jobApplicationRepository.findById(id)
                .orElseThrow(() -> new JobApplicationNotFoundException(id));
    }

    public JobApplication updateJobApplication(int id, JobApplication jobApplication) {
        JobApplication existingJob = jobApplicationRepository.findById(id)
                .orElseThrow(() -> new JobApplicationNotFoundException(id));

        existingJob.setCompanyName(jobApplication.getCompanyName());
        existingJob.setJobTitle(jobApplication.getJobTitle());
        existingJob.setLocation(jobApplication.getLocation());
        existingJob.setJobType(jobApplication.getJobType());
        existingJob.setApplicationStatus(jobApplication.getApplicationStatus());
        existingJob.setApplicationDate(jobApplication.getApplicationDate());
        existingJob.setSalaryRange(jobApplication.getSalaryRange());
        existingJob.setJobLink(jobApplication.getJobLink());
        existingJob.setNotes(jobApplication.getNotes());

        return jobApplicationRepository.save(existingJob);
    }

    public void deleteJobApplication(int id) {
        if (!jobApplicationRepository.existsById(id)) {
            throw new JobApplicationNotFoundException(id);
        }

        jobApplicationRepository.deleteById(id);
    }

    public List<JobApplication> getJobApplicationsByStatus(String status) {
        return jobApplicationRepository.findByApplicationStatus(status);
    }

    public DashboardResponseDto getDashboardData() {
        long total = jobApplicationRepository.count();
        long applied = jobApplicationRepository.countByApplicationStatus("APPLIED");
        long interview = jobApplicationRepository.countByApplicationStatus("INTERVIEW");
        long offer = jobApplicationRepository.countByApplicationStatus("OFFER");
        long rejected = jobApplicationRepository.countByApplicationStatus("REJECTED");
        long saved = jobApplicationRepository.countByApplicationStatus("SAVED");

        return new DashboardResponseDto(
                total,
                applied,
                interview,
                offer,
                rejected,
                saved
        );
    }
}