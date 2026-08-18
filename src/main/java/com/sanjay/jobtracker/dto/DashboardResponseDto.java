package com.sanjay.jobtracker.dto;

public class DashboardResponseDto {

    private long total;
    private long applied;
    private long interview;
    private long offer;
    private long rejected;
    private long saved;

    public DashboardResponseDto(long total, long applied, long interview, long offer, long rejected, long saved) {
        this.total = total;
        this.applied = applied;
        this.interview = interview;
        this.offer = offer;
        this.rejected = rejected;
        this.saved = saved;
    }

    public long getTotal() {
        return total;
    }

    public long getApplied() {
        return applied;
    }

    public long getInterview() {
        return interview;
    }

    public long getOffer() {
        return offer;
    }

    public long getRejected() {
        return rejected;
    }

    public long getSaved() {
        return saved;
    }
}