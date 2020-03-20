package kz.iitu.jparepositorypayment.event.handler;

import kz.iitu.jparepositorypayment.event.UpdateSalaryEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class UpdateSalaryHandler  implements ApplicationListener<UpdateSalaryEvent> {
    @Override
    public void onApplicationEvent(UpdateSalaryEvent updateSalaryEvent) {
        System.out.println("----------------------------------------------------");
        System.out.println("Salary updated: " + updateSalaryEvent.getEmployee());
        System.out.println("----------------------------------------------------");
    }
}