import models.AllWork;
import models.Employee;
import models.Task;
import models.Team;


import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SchedulerApplication {

    public static void main(String[] args) {
        // Creating an array of Tasks:
        AllWork workTasks = new AllWork();

        /* Filling the array of Tasks: */
        workTasks.addTask(new Task("cleaning their workplace" ,));
        workTasks.addTask(new Task("painting the walls of the office", 2,6));
        workTasks.addTask(new Task("talking to the new clients and making arrangements for the upcoming business trip",));
        workTasks.addTask(new Task("making decisions about allocating new financial resources",));
        workTasks.addTask(new Task("ordering catering for the Business meeting and preparing the menu", ));
        workTasks.addTask(new Task("arranging the special Banquet for all the employees before the Holidays", ));
        workTasks.addTask(new Task("holding a special seminar about increasing the productivity and the motivation of the employees for the Team managers of the Company", 4));
        workTasks.addTask(new Task("Having fun at the office",)); // This task will not enter the array, because the array is already full

    }

    {
        // Create some employees and teams
        Employee jovitah = new Employee("jovitah");
        Employee jessie = new Employee("jessie ");
        Employee Janice = new Employee("Janice ");
        Employee joram = new Employee("joram ");
        Employee Kaskya = new Employee("Kaskya ");
        Employee Joan = new Employee("Joan ");
        Employee Kato = new Employee("Kato ");
        Employee Bushira = new Employee("Bushira");

        // creating Teams
        Team teamA = new Team("Team A");
        Team teamB = new Team("Team B");
        Team teamC = new Team("Team C");
        Team teamD = new Team("Team D");

        // Assign employees to teams
        teamA.addEmployee(jovitah);
        teamA.addEmployee(jessie);
        teamB.addEmployee(Janice);
        teamB.addEmployee(joram);
        teamC.addEmployee(Kaskya);
        teamC.addEmployee(Joan);
        teamD.addEmployee(Kato);
        teamD.addEmployee(Bushira);


        class Team {

            private String name;

            private ArrayList<Employee> employees;

            public Team(String name) {
                this.name = name;
                this.employees = new ArrayList<>();
            }

            public void addEmployee(Employee employee) {
                // Make sure the employee doesn't already belong to another team
                if (employee.getTeam() != null) {
                    System.out.println("Employee already belongs to a team");
                    return;
                }

                // Add the employee to the team
                employees.add(employee);
                employee.setTeam(this);
            }

            public String getName() {
                return name;
            }

            public ArrayList<Employee> getEmployees() {
                return employees;
            }

        }

        class Employee {

            private String name;

            private models.Team team;

            public Employee(String name) {
                this.name = name;
                this.team = null;
            }

            public void setTeam(models.Team team) {
                this.team = team;
            }

            public models.Team getTeam() {
                return team;
            }

            public String getName() {
                return name;
            }

        }
        class SchedulingProgram {

            public void main(String[] args) {


                // Print team information
                System.out.println(teamA.getName() + " employees:");
                for (models.Employee employee : teamA.getEmployees()) {
                    System.out.println("- " + employee.getName());
                }

                System.out.println(teamB.getName() + " employees:");
                for (models.Employee employee : teamB.getEmployees()) {
                    System.out.println("- " + employee.getName());
                }

                System.out.println(teamC.getName() + " employees:");
                for (models.Employee employee : teamC.getEmployees()) {
                    System.out.println("- " + employee.getName());
                }

                System.out.println(teamD.getName() + " employees:");
                for (models.Employee employee : teamD.getEmployees()) {
                    System.out.println("- " + employee.getName());
                }

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
                return true;
            }

        }
    }
}