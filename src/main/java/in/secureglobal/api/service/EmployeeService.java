package in.secureglobal.api.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.secureglobal.api.domain.Employee;
import in.secureglobal.api.repository.EmployeeRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EmployeeService {
 
    @Autowired
    EmployeeRepository employeeRepository;
 
    public Flux<Employee> getAllEmployees() {
        Flux<Employee> employees =  employeeRepository.findAll();
        return employees;
    }
 
    public Mono<Employee> getEmployeeById(String id) {
        return employeeRepository.findById(id);
    }
    
    public Mono<Void> deleteEmployeeById(String id) {
        return employeeRepository.deleteById(id);
    }
    
    public Mono<Employee> createEmployee(Employee employee) {
    	employee.setId(UUID.randomUUID().toString());
        return employeeRepository.insert(employee);
    }
    
    public Mono<Employee> updateEmployee(String id, Employee employee) {
    	employee.setId(id);
        return employeeRepository.save(employee);
    }
}
