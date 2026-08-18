package com.sanjay.jobtracker.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity
public class JobApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Company name is required")
    private String companyName;

    @NotBlank(message = "Job title is required")
    private String jobTitle;

    private String location;
    private String jobType;

    @NotBlank(message = "Application status is required")
    private String applicationStatus;

    @NotNull(message = "Application date is required")
    private LocalDate applicationDate;
    private String salaryRange;
    private String jobLink;

    @Column(length = 1000)
    private String notes;

    public JobApplication() {
    }

    public JobApplication(String companyName, String jobTitle, String location, String jobType,
                          String applicationStatus, LocalDate applicationDate, String salaryRange,
                          String jobLink, String notes) {
        this.companyName = companyName;
        this.jobTitle = jobTitle;
        this.location = location;
        this.jobType = jobType;
        this.applicationStatus = applicationStatus;
        this.applicationDate = applicationDate;
        this.salaryRange = salaryRange;
        this.jobLink = jobLink;
        this.notes = notes;
    }

    public int getId() {
        return id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public String getLocation() {
        return location;
    }

    public String getJobType() {
        return jobType;
    }

    public String getApplicationStatus() {
        return applicationStatus;
    }

    public LocalDate getApplicationDate() {
        return applicationDate;
    }

    public String getSalaryRange() {
        return salaryRange;
    }

    public String getJobLink() {
        return jobLink;
    }

    public String getNotes() {
        return notes;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public void setApplicationStatus(String applicationStatus) {
        this.applicationStatus = applicationStatus;
    }

    public void setApplicationDate(LocalDate applicationDate) {
        this.applicationDate = applicationDate;
    }

    public void setSalaryRange(String salaryRange) {
        this.salaryRange = salaryRange;
    }

    public void setJobLink(String jobLink) {
        this.jobLink = jobLink;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}