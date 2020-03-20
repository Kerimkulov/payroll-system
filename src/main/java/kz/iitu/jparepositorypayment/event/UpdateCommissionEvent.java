package kz.iitu.jparepositorypayment.event;


import kz.iitu.jparepositorypayment.model.Employee;
import org.springframework.context.ApplicationEvent;

public class UpdateCommissionEvent extends ApplicationEvent {
    private Employee employee;
    public UpdateCommissionEvent(Object source, Employee employee) {
        super(source);
        this.employee = employee;
    }
    public Employee getEmployee(){
        return this.employee;
    }
}

