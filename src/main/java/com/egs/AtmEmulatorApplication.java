package com.egs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class AtmEmulatorApplication {
    public static void main(String[] args) {
        SpringApplication.run(AtmEmulatorApplication.class, args);
    }
}
