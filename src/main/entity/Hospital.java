package main.entity;

import java.util.ArrayList;

public class Hospital {
    private String name;
    private ArrayList<Department> departments = new ArrayList<>();

    public Hospital(){}

    public Hospital(String name) {
        this.name = name;
        departments = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(ArrayList<Department> departments) {
        this.departments = departments;
    }

    public void addDepartment(Department department) {
        departments.add(department);
    }

    @Override
    public String toString() {
        StringBuilder departmentsStr = new StringBuilder();
        for(Department d: departments) {
            departmentsStr.append("  ").append(d).append('\n');
        }
        return "Hospital: " + name + ", departments:\n" + departmentsStr;
    }
}
