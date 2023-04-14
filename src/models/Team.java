package models;

import java.util.ArrayList;


public class Team {
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

public class Employee {
    private String name;
    private Team team;

    public Employee(String name) {
        this.name = name;
        this.team = null;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Team getTeam() {
        return team;
    }

    public String getName() {
        return name;
    }
}


    



















