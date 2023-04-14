import models.Employee;
import models.Task;
import models.Team;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

class Scheduler {
    private final List<Employee> employees;
    private final List<Team> teams;

    public Scheduler() {
        this.employees = new ArrayList<>();
        this.teams = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void addTeam(Team team) {
        teams.add(team);
    }

    public void scheduleTasks(LocalDate startDate, LocalDate endDate, List<Task> tasks) {
        LocalDate currentDate = startDate;
        int currentTaskIndex = 0;

        while (!currentDate.isAfter(endDate)) {
            // Check if current date is a weekday
            if (currentDate.getDayOfWeek() == DayOfWeek.SATURDAY || currentDate.getDayOfWeek() == DayOfWeek.SUNDAY) {
                currentDate = currentDate.plusDays(1);
                continue;
            }

            // Get the available teams for the current date
            List<Team> availableTeams = new ArrayList<>();
            for (Team team : teams) {
                boolean isAvailable = true;
                for (Employee employee : team.getEmployees()) {
                    if (!isEmployeeAvailable(employee, currentDate)) {
                        isAvailable = false;
                        break;
                    }
                }
                if (isAvailable) {
                    availableTeams.add(team);
                }
            }

            // Assign the next task to an available team
            if (currentTaskIndex < tasks.size() && availableTeams.size() > 0) {
                Task task = tasks.get(currentTaskIndex);
                Team team = availableTeams.get(0);
                task.setStartDate(currentDate);
                task.setEndDate(task.getEndDate());
                task.setTeam(team);
                currentTaskIndex++;
            }

            currentDate = currentDate.plusDays(1);
        }
    }

    private boolean isEmployeeAvailable(Employee employee, LocalDate date) {
        // Check if employee is available on the given date
        // Add any additional availability constraints here if necessary
        return true;
    }
}
