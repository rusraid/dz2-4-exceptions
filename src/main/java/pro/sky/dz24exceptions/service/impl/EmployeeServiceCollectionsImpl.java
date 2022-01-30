package pro.sky.dz24exceptions.service.impl;

import org.springframework.stereotype.Service;
import pro.sky.dz24exceptions.data.Employee;
import pro.sky.dz24exceptions.exceptions.EmployeeArrayFullException;
import pro.sky.dz24exceptions.exceptions.EmployeeExistException;
import pro.sky.dz24exceptions.exceptions.EmployeeNotFoundException;
import pro.sky.dz24exceptions.service.EmployeeCollectionsService;
import pro.sky.dz24exceptions.service.EmployeeService;

import java.util.HashSet;
import java.util.Set;

@Service
public class EmployeeServiceCollectionsImpl implements EmployeeCollectionsService {

    private Set<Employee> employees = new HashSet<>();

    @Override
    public Employee addEmployee(String firstName, String lastName) {

        Employee addingEmployee = new Employee(firstName, lastName);

        if (employees.contains(addingEmployee)) {
            throw new EmployeeExistException("This employee has been already added");
        }

        employees.add(addingEmployee);
        return addingEmployee;
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        Employee removingEmployee = new Employee(firstName, lastName);

        if (!employees.remove(removingEmployee)) {
            throw new EmployeeNotFoundException("This employee can't be found");
        }
        return removingEmployee;
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        Employee findingEmployee = new Employee(firstName, lastName);

        if (!employees.contains(findingEmployee)) {
            throw new EmployeeNotFoundException("This employee can't be found");
        }
        return findingEmployee;
    }

    @Override
    public Set<Employee> getAllEmployees() {
        return employees;
    }
}
