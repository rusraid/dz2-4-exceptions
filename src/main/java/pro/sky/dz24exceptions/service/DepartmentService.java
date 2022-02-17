package pro.sky.dz24exceptions.service;

import pro.sky.dz24exceptions.data.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface DepartmentService {

    Employee findEmployeeWithMaxSalaryByDepartmentId(int departmentId);

    Employee findEmployeeWithMinSalaryByDepartmentId(int departmentId);

    Collection<Employee> findEmployeesByDepartmentId(int departmentId);

    Map<Integer, List<Employee>> findAllEmployeesByDepartmentId();
}
