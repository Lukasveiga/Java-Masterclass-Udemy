package com.masterclass.oldcontent.section17.employees;

import java.util.ArrayList;
import java.util.List;

public class Department {

    private String name;
    private List<Employee> employees;

    public Department(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        if (employee != null) {
            employees.add(employee);
        } else {
            System.out.println("Object is null.");
        }
    }

    public String getName() {
        return name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    @Override
    public String toString() {
        return "Department:" + name + "; Employees:" + employees;
    }


}
