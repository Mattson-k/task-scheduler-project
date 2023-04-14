package models;

import java.time.LocalDate;

public class Task {
    private  String name;
    private LocalDate startDate;
    private LocalDate endDate;
    private Team team;
    private int workingHours;

    public Task(String name, LocalDate startDate, LocalDate endDate, Team team, int workingHours) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.team = team;
        this.workingHours =workingHours;
    }

    public String getName() {
        return name;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public Team getTeam() {
        return team;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public void setWorkingHours (final int newWorkingHours) {
        if (newWorkingHours>=0) {
            this.workingHours=newWorkingHours;
        }
    }

    public int getWorkingHours () {
        return this.workingHours;
    }
}


