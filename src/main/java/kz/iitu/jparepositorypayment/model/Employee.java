package kz.iitu.jparepositorypayment.model;

import kz.iitu.jparepositorypayment.employeeEnum.EmployeeType;

import javax.persistence.*;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double fixedSalary;
    private double hourRate;
    private int hoursWorked;
    private int empSales;
    private float commRate;

    @Enumerated(EnumType.STRING)
    private EmployeeType employeeType;

    public void setName(String name) {
        this.name = name;
    }

    public void setFixedSalary(double fixedSalary) {
        this.fixedSalary = fixedSalary;
    }

    public void setHourRate(double hourRate) {
        this.hourRate = hourRate;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public void setCommRate(float commRate) {
        this.commRate = commRate;
    }

    public void setEmployeeType(EmployeeType employeeType) {
        this.employeeType = employeeType;
    }

    public int getEmpSales() {
        return empSales;
    }

    public void setEmpSales(int empSales) {
        this.empSales = empSales;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getFixedSalary() {
        return fixedSalary;
    }

    public double getHourRate() {
        return hourRate;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public float getCommRate() {
        return commRate;
    }

    public EmployeeType getEmployeeType() {
        return this.employeeType;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", fixedSalary=" + fixedSalary +
                ", hourRate=" + hourRate +
                ", hoursWorked=" + hoursWorked +
                ", empSales=" + empSales +
                ", commRate=" + commRate +
                ", employeeType=" + employeeType +
                '}';
    }
}
