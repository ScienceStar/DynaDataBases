package application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@MapperScan( "com.mmzs.springboot.s00.application")
public class StaticScheduleTaskApplication {
    public static void main(String[] args) {
        SpringApplication.run(StaticScheduleTaskApplication.class, args);
    }
}