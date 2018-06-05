package com.demo.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication(scanBasePackages={"com.demo"})// same as @Configuration @EnableAutoConfiguration @ComponentScan combined
public class Demo 
{
    public static void main( String[] args )
    {
		SpringApplication.run(Demo.class, args);
    }
}
