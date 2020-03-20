package kz.iitu.jparepositorypayment;

import kz.iitu.jparepositorypayment.dao.EmployeeDao;
import kz.iitu.jparepositorypayment.employeeEnum.EmployeeType;
import kz.iitu.jparepositorypayment.model.Employee;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Scanner;

public class Main {
    static AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
    static EmployeeDao employeeDao =context.getBean("employeeDao", EmployeeDao.class);
    static Scanner cin = new Scanner(System.in);
    public static void main(String[] args) {

//        Employee hourly = new Employee();
//        hourly.setName("Houry Employee");
//        hourly.setEmployeeType(EmployeeType.HOURLY);
//        hourly.setHourRate(1.5);
//        hourly.setHoursWorked(155);
//        hourly.setFixedSalary(5000);
//
//        Employee salaried = new Employee();
//        salaried.setName("Salaried Employee");
//        salaried.setEmployeeType(EmployeeType.SALARIED);
//        salaried.setFixedSalary(150000);
//
//        Employee commission = new Employee();
//        commission.setName("Commission Employee");
//        commission.setEmployeeType(EmployeeType.COMMISSION);
//        commission.setEmpSales(150000);
//        commission.setCommRate(3);
//
//        Employee salariedCommission = new Employee();
//        salariedCommission.setName("SalariedCommission Employee");
//        salariedCommission.setEmployeeType(EmployeeType.SALARIED_COMMISSION);
//        salariedCommission.setFixedSalary(300000);
//        salariedCommission.setEmpSales(150000);
//        salariedCommission.setCommRate(5);
//
//        employeeDao.createEmployee(salaried);
//        employeeDao.createEmployee(hourly);
//        employeeDao.createEmployee(salariedCommission);
//        employeeDao.createEmployee(commission);

        int quit = 1;
        int quit2 = 1;
        int quit3 = 1;
        long emp_id;

        while (quit != 0){
            System.out.println("Choose option:");
            System.out.println("1. Calculate Salary");
            System.out.println("2. Update salary:");
            System.out.println("0. Quit");
            int option = cin.nextInt();
            if (option == 1) {
                quit2 = 1;
                while (quit2 != 0) {
                    System.out.println("Choose Employee: ");
                    getEmployees();
                    System.out.println("Press 0 to quit.");
                    emp_id = cin.nextInt();
                    if (emp_id != 0) {
                        Employee employee = employeeDao.findById(emp_id);
                        employeeDao.calculateSalary(employee.getEmployeeType(), emp_id);
                    }
                    else {
                        quit2 = 0;
                        break;
                    }
                }
            }
            else if(option == 2){
                quit3 = 1;
                while (quit3 != 0) {
                    System.out.println("Choose Employee: ");
                    getEmployees();
                    System.out.println("Press 0 to quit.");
                    emp_id = cin.nextInt();
                    if (emp_id != 0) {
                        employeeDao.updateEmployee(emp_id);
                    }
                    else {
                        quit3 = 0;
                        break;
                    }
                }
            }
            else {
                quit = 0;
            }
        }



    }
    public static void getEmployees(){
        List<Employee> employees = employeeDao.getAll();
        for (Employee employee1: employees){
            System.out.println(employee1);
        }
    }

}
