package by.bsu.seredinski;

import models.Employees;
import models.EmployeesWithoutSalary;

import java.util.ArrayList;

public class Sorting {

    public static void sortingBySalary(ArrayList<Employees> employeesDb, ArrayList<EmployeesWithoutSalary> employeesWithoutSalaryDb) {

        int[] array = new int[employeesDb.size()];
        for (int i = 0; i < array.length; i++) {
            array[i] = employeesDb.get(i).salary;
            System.out.print(array[i] + " ");
        }

        Algorithms.mergeSort(array, 0, array.length - 1);

        System.out.println();
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < employeesDb.size(); i++) {
            for (int j = 0; j < employeesDb.size(); j++) {
                if (array[i] == employeesDb.get(j).salary) {

                    Employees a = employeesDb.get(i);
                    employeesDb.set(i, employeesDb.get(j));
                    employeesDb.set(j, a);

                    EmployeesWithoutSalary b = employeesWithoutSalaryDb.get(i);
                    employeesWithoutSalaryDb.set(i, employeesWithoutSalaryDb.get(j));
                    employeesWithoutSalaryDb.set(j, b);
                }
            }
        }
    }

}
