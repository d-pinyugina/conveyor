package ru.nf.conveyor.model;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class LoanApplicationRequestDTO {

	/**
	 * Имя
	 */
	private String firstName;

	/**
	 * Фамилия
	 */
	private String lastName;

	/**
	 * Отчество
	 */
	private String middleName;

	/**
	 * Сумма кредита
	 */
	private Double amount;

	/**
	 * Срок кредита
	 */
	private Integer term;

	/**
	 * Дата рождения
	 */
	private LocalDate birthDate;

	/**
	 * почта
	 */
	private String email;

	/**
	 * Серия паспорта
	 */
	private String passportSeries;

	/**
	 * Номер паспорта
	 */
	private String passportNumber;
}
