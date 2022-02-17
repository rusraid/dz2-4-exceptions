package pro.sky.dz24exceptions.service.impl;

import org.springframework.stereotype.Service;
import pro.sky.dz24exceptions.data.Employee;
import pro.sky.dz24exceptions.exceptions.EmployeeExistException;
import pro.sky.dz24exceptions.exceptions.EmployeeNotFoundException;
import pro.sky.dz24exceptions.service.EmployeeMapService;

import java.util.*;

@Service
public class EmployeeServiceMapImpl implements EmployeeMapService {

    private final Map<String, Employee> employees = new HashMap<>();

    @Override
    public Employee addEmployee(String firstName, String lastName) {

        Employee addingEmployee = new Employee(firstName, lastName);

        String key = firstName + lastName;
        if (employees.containsKey(key)) {
            throw new EmployeeExistException("This employee has been already added");
        }
        employees.put(key, addingEmployee);
        return addingEmployee;
    }

    @Override
    public Employee addEmployee(String firstName, String lastName, int salary, int departmentId) {

        Employee addingEmployee = new Employee(firstName, lastName, salary, departmentId);

        String key = firstName + lastName;
        if (employees.containsKey(key)) {
            throw new EmployeeExistException("This employee has been already added");
        }
        employees.put(key, addingEmployee);
        return addingEmployee;
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        String key = firstName + lastName;
        if (!employees.containsKey(key)) {
            throw new EmployeeNotFoundException("This employee can't be found");
        }
        return employees.remove(key);
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        String key = firstName + lastName;
        if (!employees.containsKey(key)) {
            throw new EmployeeNotFoundException("This employee can't be found");
        }
        return employees.get(key);
    }

    @Override
    public Collection<Employee> getAllEmployees() {
        return Collections.unmodifiableCollection(employees.values());
    }
}
