package ru.nf.conveyor.model;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

/**
 * Класс кредитных предложений
 */

public class LoanOfferDTO {
	/**
	 * Запрашиваемая сумма
	 */
	private BigDecimal requestedAmount;
	/**
	 * Общая сумма
	 */
	private BigDecimal totalAmount;
	/**
	 * Срок кредита
	 */
	private Integer term;
	/**
	 * Ежемесячный платеж
	 */
	private BigDecimal monthlyPayment;
	/**
	 * Ставка
	 */
	private BigDecimal rate;
	/**
	 * Включена страховка?
	 */
	private Boolean isInsuranceEnabled;
	/**
	 * Зарплатный клиент?
	 */
	private Boolean isSalaryClient;
}
