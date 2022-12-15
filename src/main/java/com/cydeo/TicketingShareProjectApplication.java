package com.cydeo;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TicketingShareProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(TicketingShareProjectApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper(){
        return modelMapper();
    }
}
