package pro.sky.dz24exceptions.service;

import pro.sky.dz24exceptions.data.Employee;

import java.util.Set;

public interface EmployeeCollectionsService {


    Employee addEmployee(String firstName, String lastName);

    Employee removeEmployee(String firstName, String lastName);

    Employee findEmployee(String firstName, String lastName);

    Set<Employee> getAllEmployees();
}
