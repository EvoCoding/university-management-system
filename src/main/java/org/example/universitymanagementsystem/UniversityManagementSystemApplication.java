package org.example.universitymanagementsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true, proxyTargetClass = true, jsr250Enabled = true)
public class UniversityManagementSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(UniversityManagementSystemApplication.class, args);
    }

}
