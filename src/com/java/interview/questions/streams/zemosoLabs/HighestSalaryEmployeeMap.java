package com.java.interview.questions.streams.zemosoLabs;

import java.util.*;

public class HighestSalaryEmployeeMap {

    public static void main(String[] args) {

        /*
        * Using streams find the employee with the highest salary
        result should be a Map<String, Employee>
        * */
        List<Employee> list = Arrays.asList(
                new Employee(1, "John", 20000.0),
                new Employee(2, "Vikram", 32000.0),
                new Employee(3, "Santosh", 50000.0),
                new Employee(4, "Prasad", 25000.0),
                new Employee(5, "Yash", 28000.0));

        Map<String, Employee> out = list.stream()
                .max(Comparator.comparing(Employee::getSalary))
                .map(emp -> Map.of(emp.getName(), emp)).get();
        System.out.println(out);
    }
}


class Employee{

    private  int id;
    private  String name;
    private  Double salary;

    public Employee(int id, String name, Double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && Objects.equals(name, employee.name) && Objects.equals(salary, employee.salary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, salary);
    }
}