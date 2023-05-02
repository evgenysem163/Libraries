package sky.pro.employeebook.service;


import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import sky.pro.employeebook.exceptions.InvalidInputException;
import sky.pro.employeebook.exceptions.NotFindException;
import sky.pro.employeebook.models.Employee;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final List<Employee> employees = new ArrayList<>();
    public Employee addEmployee(Employee employee) {
        if(!validator(employee.getFirstName(),employee.getLastName()))
            throw new InvalidInputException();
        employees.add(employee);
        return employee;
    }


    public Employee findMaxSalaryFromDepartment(int department) throws NotFindException {
        return employees.stream()
                .filter(emp -> emp.getDepartment() == department)       // Фильтр по отделам
                .max(Comparator.comparing(Employee::getSalary)) // Фильтр по максимальному значение getSalary
                .orElseThrow(() -> new NotFindException(" Сотрудник с максимальной зарплатой не найден ")); // Выброс исключения
    }

    public Employee findMinSalaryFromDepartment(int department) throws NotFindException {
        return employees.stream()
                .filter(emp -> emp.getDepartment() == department)
                .min(Comparator.comparing(Employee::getSalary))
                .orElseThrow(() -> new NotFindException(" Сотрудник с минимальной зарплатой не найден "));
    }

    public List<Employee> findEmployeeFromDepartment(int department) {
        return employees.stream()
                .filter(emp -> emp.getDepartment() == department)
                .collect(Collectors.toList());
    }

    public List<Employee> findAllEmployeesFromDepartment() {
        return employees.stream()
                .sorted(Comparator.comparingInt(Employee::getDepartment))
                .collect(Collectors.toList());
    }

    private boolean validator(String firstName, String lastName ){
        return StringUtils.isAlpha(firstName) && StringUtils.isAlpha(lastName);
    }
}