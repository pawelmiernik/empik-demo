package com.example.epmikdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example.epmikdemo")
public class EpmikDemoApplication {

  public static void main(String[] args) {
    SpringApplication springApplication = new SpringApplication(EpmikDemoApplication.class);
    springApplication.run(args);
  }

}
