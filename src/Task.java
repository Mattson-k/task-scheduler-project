import java.time.LocalDate;

public class Task {
    private final String name;
    private LocalDate startDate;
    private LocalDate endDate;
    private final Team team;

    public Task(String name, LocalDate startDate, LocalDate endDate, Team team) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.team = team;
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

    public void setTeam(Team team) {

    }
}
