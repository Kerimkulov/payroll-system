package kz.iitu.jparepositorypayment.event.handler;

import kz.iitu.jparepositorypayment.event.UpdateCommissionEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class UpdateCommissionHandler  implements ApplicationListener<UpdateCommissionEvent> {
    @Override
    public void onApplicationEvent(UpdateCommissionEvent updateCommissionEvent) {
        System.out.println("----------------------------------------------------");
        System.out.println("Hours updated: " + updateCommissionEvent.getEmployee());
        System.out.println("----------------------------------------------------");
    }
}