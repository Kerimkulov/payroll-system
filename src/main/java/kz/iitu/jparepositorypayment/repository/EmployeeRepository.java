package kz.iitu.jparepositorypayment.repository;

import kz.iitu.jparepositorypayment.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
