package pro.sky.dz24exceptions.service.impl;

import org.springframework.stereotype.Service;
import pro.sky.dz24exceptions.data.Employee;
import pro.sky.dz24exceptions.exceptions.EmployeeNotFoundException;
import pro.sky.dz24exceptions.service.DepartmentService;
import pro.sky.dz24exceptions.service.EmployeeMapService;
import pro.sky.dz24exceptions.service.EmployeeService;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final EmployeeMapService employeeService;

    public DepartmentServiceImpl(EmployeeMapService employeeService) {
        this.employeeService = employeeService;
    }


    @Override
    public Employee findEmployeeWithMaxSalaryByDepartmentId(int departmentId) {
        return employeeService.getAllEmployees().stream()
                .filter(employee -> employee.getDepartmentId() == departmentId)
                .max(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(() -> new EmployeeNotFoundException("This employee can't be found"));
//                .orElseThrow(EmployeeNotFoundException::new);
    }
// employee -> employee.getSalary() тоже самое что и Employee::getSalary
    @Override
    public Employee findEmployeeWithMinSalaryByDepartmentId(int departmentId) {
        return employeeService.getAllEmployees().stream()
                .filter(employee -> employee.getDepartmentId() == departmentId)
                .min(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(() -> new EmployeeNotFoundException("This employee can't be found"));
    }

    @Override
    public Collection<Employee> findEmployeesByDepartmentId(int departmentId) {
        return employeeService.getAllEmployees().stream()
                .filter(employee -> employee.getDepartmentId() == departmentId)
                .collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<Employee>> findAllEmployeesByDepartmentId() {
        return employeeService.getAllEmployees().stream()
                .collect(Collectors.groupingBy(Employee::getDepartmentId));
    }
}
