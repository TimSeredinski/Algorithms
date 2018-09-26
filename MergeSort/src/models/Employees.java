package models;

public class Employees {

    public int age;
    public String name;
    public int salary;

    public Employees(int age, String name, int salary) {
        this.age = age;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employees{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
