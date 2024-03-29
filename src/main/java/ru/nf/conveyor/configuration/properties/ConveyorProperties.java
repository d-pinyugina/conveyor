package ru.nf.conveyor.configuration.properties;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@Getter
@ConstructorBinding
@ConfigurationProperties("conveyor")
public class ConveyorProperties {

	/**
	 * Константа для базовой кредитной ставки
	 */
	private final Double baseRate;

	public ConveyorProperties(Double baseRate) {
		this.baseRate = baseRate;
	}
}
