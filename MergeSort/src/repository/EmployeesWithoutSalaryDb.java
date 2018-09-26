package repository;

import models.EmployeesWithoutSalary;

import java.util.ArrayList;

public class EmployeesWithoutSalaryDb {

    public static ArrayList<EmployeesWithoutSalary> employeesWithoutSalaries;

    public static void employeesWithoutSalaryDb(){
        employeesWithoutSalaries = new ArrayList<>();
        EmployeesWithoutSalary empl1 = new EmployeesWithoutSalary(20, "Tim");
        EmployeesWithoutSalary empl2 = new EmployeesWithoutSalary(24, "Nick");
        EmployeesWithoutSalary empl3 = new EmployeesWithoutSalary(21, "John");
        EmployeesWithoutSalary empl4 = new EmployeesWithoutSalary(22, "Alex");

        employeesWithoutSalaries.add(empl1);
        employeesWithoutSalaries.add(empl2);
        employeesWithoutSalaries.add(empl3);
        employeesWithoutSalaries.add(empl4);
    }
}
