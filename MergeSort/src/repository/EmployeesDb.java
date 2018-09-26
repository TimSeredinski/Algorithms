package repository;

import models.Employees;

import java.util.ArrayList;

public class EmployeesDb {

    public static ArrayList<Employees> employees;

    public static void employeesDb(){
        employees = new ArrayList<>();
        Employees emp1 = new Employees(20, "Tim", 450);
        Employees emp2 = new Employees(24, "Nick", 1800);
        Employees emp3 = new Employees(21, "John", 300);
        Employees emp4 = new Employees(22, "Alex", 1000);

        employees.add(emp1);
        employees.add(emp2);
        employees.add(emp3);
        employees.add(emp4);
    }
}
