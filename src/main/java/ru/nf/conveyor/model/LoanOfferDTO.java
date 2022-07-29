package ru.nf.conveyor.model;

import lombok.*;

import java.math.BigDecimal;
import java.time.temporal.TemporalAmount;

/**
 * Класс кредитных предложений
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LoanOfferDTO {

	/**
	 * Запрашиваемая сумма
	 */
	private Double requestedAmount;

	/**
	 * Общая сумма
	 */
	private Double totalAmount;

	/**
	 * Срок кредита
	 */
	private Integer term;

	/**
	 * Ежемесячный платеж
	 */
	private Double monthlyPayment;

	/**
	 * Ставка
	 */
	private Double rate;

	/**
	 * Включена страховка?
	 */
	private Boolean isInsuranceEnabled;

	/**
	 * Зарплатный клиент?
	 */
	private Boolean isSalaryClient;
}
