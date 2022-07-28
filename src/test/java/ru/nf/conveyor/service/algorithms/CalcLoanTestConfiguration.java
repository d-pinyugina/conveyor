package ru.nf.conveyor.service.algorithms;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.TestPropertySource;

@Configuration
@ComponentScan(value = "ru.nf.conveyor")
@TestPropertySource("classpath:application-test.yml")
public class CalcLoanTestConfiguration {

}
