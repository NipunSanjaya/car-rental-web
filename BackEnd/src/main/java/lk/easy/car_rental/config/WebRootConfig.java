package lk.easy.car_rental.config;

import lk.easy.car_rental.service.*;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


@Configuration
@Import(JPAConfig.class)
@ComponentScan(basePackageClasses = {CustomerService.class,UserService.class, DriverService.class, CarService.class, RentService.class, PaymentService.class})
public class WebRootConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
