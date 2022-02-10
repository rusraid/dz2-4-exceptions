package pro.sky.dz24exceptions.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.dz24exceptions.data.Employee;
import pro.sky.dz24exceptions.service.EmployeeMapService;

import java.util.Collection;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeMapService employeeService;

    public EmployeeController(EmployeeMapService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/")
    public String greetEmployee() {
        return "Hello employess!";
    }

//    @GetMapping("/add")
//    public Employee addEmployee(@RequestParam ("firstName") String firstname,
//                                @RequestParam ("lastName") String lastname) {
////        Employee addedEmployee = employeeService.addEmployee(firstname, lastname);
////        return addedEmployee;
//        return employeeService.addEmployee(firstname, lastname);
//    }

    @GetMapping("/add")
    public Employee addEmployee(@RequestParam ("firstName") String firstname,
                                @RequestParam ("lastName") String lastname,
                                @RequestParam ("salary") int salary,
                                @RequestParam ("departmentId") int departmentId) {
        return employeeService.addEmployee(firstname, lastname, salary, departmentId);
    }

    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam ("firstName") String firstname,
                              @RequestParam ("lastName") String lastname) {
//        Employee removedEmployee = employeeService.removeEmployee(firstname, lastname);
//        return removedEmployee;
        return employeeService.removeEmployee(firstname, lastname);
    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam ("firstName") String firstname,
                              @RequestParam ("lastName") String lastname) {
//        Employee foundEmployee = employeeService.findEmployee(firstname, lastname);
//        return foundEmployee;
        return employeeService.findEmployee(firstname, lastname);
    }

    @GetMapping("/getAllEmployees")
//    public Set<Employee> getAllEmployees() {
//        return employeeService.getAllEmployees();
    public Collection<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }
}
