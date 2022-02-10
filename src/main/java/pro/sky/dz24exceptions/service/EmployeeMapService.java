package pro.sky.dz24exceptions.service;

import pro.sky.dz24exceptions.data.Employee;

import java.util.Collection;

public interface EmployeeMapService {


    Employee addEmployee(String firstName, String lastName);

    Employee addEmployee(String firstName, String lastName, int salary, int departmentId);

    Employee removeEmployee(String firstName, String lastName);

    Employee findEmployee(String firstName, String lastName);

    Collection<Employee> getAllEmployees();
}
