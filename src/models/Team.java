package models;

import java.util.ArrayList;

public class Team {

    private String name;
    private ArrayList<Employee> members;
    public Team( String name) {
        this.name = name;
        this.members = new ArrayList<Employee>();
    }
    public String getName() {
        return name;
    }

    public void addMember(Employee employee) {
        members.add(employee);
        employee.setTeam(this.name);
    }

    public ArrayList<Employee> getMembers() {
        return members;
    }

    public ArrayList<Employee> getEmployees() {
        return members;
    }
}


















