package springbootzerotohero.springbootmongodb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springbootzerotohero.springbootmongodb.dto.EmployeeDTO;
import springbootzerotohero.springbootmongodb.model.Employee;
import springbootzerotohero.springbootmongodb.repository.EmployeeRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public String create(EmployeeDTO employeeDTO) {
        try {
            Employee employee = Employee.builder()
                    .employeeName(employeeDTO.getEmployeeName())
                    .location((employeeDTO.getLocation()))
                    .salary(employeeDTO.getSalary())
                    .build();
            employeeRepository.save(employee);
        } catch (Exception e) {
            // TODO: handle exception
        }
        return "Employee created successfully";
    }

    public List<Employee> getAll() {
        List<Employee> employeeList = new ArrayList<>();
        try {
            employeeList = employeeRepository.findAll();
        } catch(Exception e) {
            // TODO: handle exception
        }
        return employeeList;
    }

    public String delete(String id) {
        try {
            employeeRepository.deleteById(id);
        } catch(Exception e) {
            // TODO: handle exception
        }
        return "Employee Deleted Successfully";
    }

    public String update(EmployeeDTO employeeDTO) {
        try {
            Employee employee = Employee.builder()
                    .id(employeeDTO.getId())
                    .employeeName(employeeDTO.getEmployeeName())
                    .location(employeeDTO.getLocation())
                    .salary(employeeDTO.getSalary())
                    .build();
        } catch (Exception e) {
            // TODO: handle exception
        }
        return "Employee Updated Suceessfully";
    }
}
