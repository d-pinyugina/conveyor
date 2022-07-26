package ru.nf.conveyor.configuration.properties;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

import java.math.BigDecimal;

@Getter
@ConstructorBinding
@ConfigurationProperties("conveyor")
public class ConveyorProperties {

	/**
	 * Константа для базовой кредитной ставки
	 */
	private final BigDecimal baseRate;

	public ConveyorProperties(BigDecimal baseRate) {
		this.baseRate = baseRate;
	}
}
