package kz.iitu.jparepositorypayment.dao;

import kz.iitu.jparepositorypayment.employeeEnum.EmployeeType;
import kz.iitu.jparepositorypayment.event.UpdateCommissionEvent;
import kz.iitu.jparepositorypayment.event.UpdateSalaryEvent;
import kz.iitu.jparepositorypayment.model.Employee;
import kz.iitu.jparepositorypayment.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Service
@Component
public class EmployeeDao implements ApplicationEventPublisherAware {

    @Autowired
    private EmployeeRepository employeeRepository;

    private ApplicationEventPublisher eventPublisher;
    public Employee findById(Long id){
        return employeeRepository.findById(id).get();
    }

    public List<Employee> getAll(){
        return employeeRepository.findAll();
    }

    public void createEmployee(Employee employee){
        employeeRepository.save(employee);
    }

    public void updateEmployee(long id){
        int salary, hours, sales;
        Scanner sc = new Scanner(System.in);
        Employee employee = this.findById(id);
        switch (employee.getEmployeeType()){
            case HOURLY:
                System.out.print("Hours: ");
                hours = sc.nextInt();
                employee.setHoursWorked(hours);
                this.eventPublisher.publishEvent(new UpdateCommissionEvent(this, employee));
                break;
            case SALARIED:
                System.out.print("New salary: ");
                salary = sc.nextInt();
                employee.setFixedSalary(salary);
                this.eventPublisher.publishEvent(new UpdateSalaryEvent(this, employee));
                break;
            case COMMISSION:
            case SALARIED_COMMISSION:
                System.out.print("Sales: ");
                sales = sc.nextInt();
                employee.setEmpSales(sales);
                this.eventPublisher.publishEvent(new UpdateSalaryEvent(this, employee));
                break;
        }
        employeeRepository.save(employee);
    }

    public void deleteEmployeeById(Long id){
        employeeRepository.deleteById(id);
    }

    public void calculateSalary(EmployeeType employeeType, long id){
        double total_salary = 0;
        Employee employee = this.findById(id);
        switch (employeeType){
            case HOURLY:
                if (employee.getHoursWorked() > 40){
                    total_salary = employee.getHoursWorked() * (double)employee.getFixedSalary() * employee.getHourRate();
                }
                else {
                    total_salary = employee.getHoursWorked() * (double)employee.getFixedSalary();
                }
                System.out.println("----------------------------------------------------");
                System.out.print(employee.toString());
                System.out.println(" total salary=" + total_salary);
                System.out.println("----------------------------------------------------");
                break;
            case SALARIED:
                System.out.println(employee.toString());
                break;
            case COMMISSION:
                total_salary = (double)employee.getEmpSales() * employee.getCommRate()/100;
                System.out.println("----------------------------------------------------");
                System.out.print(employee.toString());
                System.out.println(" total salary=" + total_salary);
                System.out.println("----------------------------------------------------");
                break;
            case SALARIED_COMMISSION:
                total_salary =  employee.getFixedSalary() +
                        (double)employee.getEmpSales() * employee.getCommRate()/100;
                System.out.println("----------------------------------------------------");
                System.out.print(employee.toString());
                System.out.println(" total salary=" + total_salary);
                System.out.println("----------------------------------------------------");
                break;
        }
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.eventPublisher = applicationEventPublisher;
    }
}
