package springbootzerotohero.springbootmongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import springbootzerotohero.springbootmongodb.model.Employee;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String> {
}
