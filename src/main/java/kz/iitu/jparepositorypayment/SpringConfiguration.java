package kz.iitu.jparepositorypayment;

import kz.iitu.jparepositorypayment.employeeEnum.EmployeeType;
import kz.iitu.jparepositorypayment.model.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "kz.iitu.jparepositorypayment")
public class SpringConfiguration {
    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/PaymentSystem");
        dataSource.setPassword("123");
        dataSource.setUsername("postgres");
        return dataSource;
    }

}
