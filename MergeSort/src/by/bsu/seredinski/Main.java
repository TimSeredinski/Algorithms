package by.bsu.seredinski;

import models.*;
import repository.*;

public class Main {

    public static void main(String[] args) {

        EmployeesDb.employeesDb();
        EmployeesWithoutSalaryDb.employeesWithoutSalaryDb();

        for(int i = 0; i < EmployeesDb.employees.size(); i++){
            System.out.println(EmployeesDb.employees.get(i));
        }
        System.out.println();
        for(int i = 0; i < EmployeesWithoutSalaryDb.employeesWithoutSalaries.size(); i++){
            System.out.println(EmployeesWithoutSalaryDb.employeesWithoutSalaries.get(i));
        }

        Sorting.sortingBySalary(EmployeesDb.employees, EmployeesWithoutSalaryDb.employeesWithoutSalaries);

        for(int i = 0; i < EmployeesDb.employees.size(); i++){
            System.out.println(EmployeesDb.employees.get(i));
        }
        System.out.println();
        for(int i = 0; i < EmployeesWithoutSalaryDb.employeesWithoutSalaries.size(); i++){
            System.out.println(EmployeesWithoutSalaryDb.employeesWithoutSalaries.get(i));
        }
    }

}
