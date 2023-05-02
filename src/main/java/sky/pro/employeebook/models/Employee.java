package sky.pro.employeebook.models;

import java.util.Objects;
import static org.apache.commons.lang3.StringUtils.*;

public class Employee {
    private String firstName;
    private String lastName;
    private int salary;
    private int department;

    public Employee(String firstName, String lastName, int salary, int department) {
        this.firstName = capitalize(firstName.toLowerCase());
        this.lastName = capitalize(lastName.toLowerCase());
        this.salary = salary;
        this.department = department;
    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }


    public int getSalary() {
        return salary;
    }

    public int getDepartment() {
        return department;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return salary == employee.salary && department == employee.department && firstName.equals(employee.firstName) && lastName.equals(employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, salary, department);
    }

    @Override
    public String toString() {
        return
                "Имя " + getFirstName() +
                        " Фамилия " + getLastName() +
                        " Зарплата " + getSalary() +
                        " Отдел " + getDepartment();
    }
}
