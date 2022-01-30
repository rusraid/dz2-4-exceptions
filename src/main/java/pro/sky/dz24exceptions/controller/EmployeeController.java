package pro.sky.dz24exceptions.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.dz24exceptions.data.Employee;
import pro.sky.dz24exceptions.service.EmployeeCollectionsService;
import pro.sky.dz24exceptions.service.EmployeeService;

import java.util.Set;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private EmployeeCollectionsService employeeService;

    public EmployeeController(EmployeeCollectionsService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/")
    public String greetEmployee() {
        return "Hello employess!";
    }
    @GetMapping("/add")
    public Employee addEmployee(@RequestParam ("firstName") String firstname,
                                @RequestParam ("lastName") String lastname) {
        Employee addedEmployee = employeeService.addEmployee(firstname, lastname);
        return addedEmployee;
    }
    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam ("firstName") String firstname,
                              @RequestParam ("lastName") String lastname) {
        Employee removedEmployee = employeeService.removeEmployee(firstname, lastname);
        return removedEmployee;
    }
    @GetMapping("/find")
    public Employee findEmployee(@RequestParam ("firstName") String firstname,
                              @RequestParam ("lastName") String lastname) {
        Employee foundEmployee = employeeService.findEmployee(firstname, lastname);
        return foundEmployee;
    }

    @GetMapping("/getAllEmployees")
    public Set<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }
}
