package ru.nf.conveyor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import ru.nf.conveyor.configuration.properties.ConveyorProperties;

@SpringBootApplication
@EnableConfigurationProperties(value = ConveyorProperties.class)
public class ConveyorApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConveyorApplication.class, args);
	}

}
