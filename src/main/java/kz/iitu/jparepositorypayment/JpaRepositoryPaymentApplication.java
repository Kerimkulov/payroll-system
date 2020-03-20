package kz.iitu.jparepositorypayment;

import kz.iitu.jparepositorypayment.employeeEnum.EmployeeType;
import kz.iitu.jparepositorypayment.model.Employee;
import kz.iitu.jparepositorypayment.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpaRepositoryPaymentApplication {

	public static void main(String[] args) {

		SpringApplication.run(JpaRepositoryPaymentApplication.class, args);

	}
//	@Bean
//	public CommandLineRunner commandLineRunner(EmployeeRepository employeeRepository
//	) {
//		return (args) ->{
//			Employee employee = new Employee();
//			employee.setName("asdsd");
//			employee.setEmployeeType(EmployeeType.HOURLY);
//			employee.setHourRate(1.5);
//			employee.setHoursWorked(155);
//			employee.setCommRate(5);
//			employee.setFixedSalary(454);
//
//			Employee hourly = new Employee();
//			hourly.setName("Hourly Employee");
//			hourly.setEmployeeType(EmployeeType.HOURLY);
//			hourly.setHourRate(1.2);
//			hourly.setHoursWorked(111);
//			hourly.setFixedSalary(1111);
//
//
//
//			employeeRepository.save(employee);
//			employeeRepository.save(hourly);
//
//			for(Employee employee1: employeeRepository.findAll()){
//				System.out.println(employee1.toString());
//			}
//			System.out.println("adsaads");
//		};
//	}
}
