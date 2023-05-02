package sky.pro.employeebook.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sky.pro.employeebook.exceptions.NotFindException;
import sky.pro.employeebook.models.Employee;
import sky.pro.employeebook.service.EmployeeService;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/departments")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public String hello() {
        return "hello";
    }

    @GetMapping("/add")
    public Employee addEmployee(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName, @RequestParam("salary") int salary, @RequestParam("department") int department) {
        return employeeService.addEmployee(new Employee(firstName, lastName, salary, department));
    }

    @GetMapping("/max-salary")
    public Employee findMaxSalaryFromDepartment(@RequestParam("departmentId") int department) throws NotFindException {
        return employeeService.findMaxSalaryFromDepartment(department);
    }

    @GetMapping("/min-salary")
    public Employee findMinSalaryFromDepartment(@RequestParam("departmentId") int department) throws NotFindException {
        return employeeService.findMinSalaryFromDepartment(department);
    }

    @GetMapping("/all")
    public List<Employee> findEmployeeFromDepartment(@RequestParam(value = "departmentId", required = false) Integer department) {
        if (department != null) {
            return employeeService.findEmployeeFromDepartment(department);
        } else {
            return employeeService.findAllEmployeesFromDepartment();
        }
    }
}

