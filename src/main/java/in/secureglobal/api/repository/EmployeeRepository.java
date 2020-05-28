package in.secureglobal.api.repository;

import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import org.springframework.stereotype.Repository;

import in.secureglobal.api.domain.Employee;

@Repository
public interface EmployeeRepository extends ReactiveCassandraRepository<Employee, String> {
    
//	@AllowFiltering
//    Flux<Employee> findByAgeGreaterThan(int age);
}

