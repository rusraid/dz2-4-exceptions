package pro.sky.dz24exceptions;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
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
}
