package com.sanjay.jobtracker.exception;

public class JobApplicationNotFoundException extends RuntimeException {
    public JobApplicationNotFoundException( int id) {
        super("Job application not found with id: " + id);
    }
}
