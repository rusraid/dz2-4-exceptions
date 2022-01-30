package pro.sky.dz24exceptions.service;

import pro.sky.dz24exceptions.data.Employee;

public interface EmployeeService{


    Employee addEmployee(String firstName, String lastName);

    Employee removeEmployee(String firstName, String lastName);

    Employee findEmployee(String firstName, String lastName);

}
