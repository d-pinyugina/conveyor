package ru.nf.conveyor.model;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data

/**
Правила прескоринга
Имя, Фамилия - от 2 до 30 латинских букв. Отчество, при наличии - от 2 до 30 латинских букв.
Сумма кредита - действительно число, большее или равное 10000.
Срок кредита - целое число, большее или равное 6.
Дата рождения - число в формате гггг-мм-дд, не позднее 18 лет с текущего дня.
Email адрес - строка, подходящая под паттерн [\w\.]{2,50}@[\w\.]{2,20}
Серия паспорта - 4 цифры, номер паспорта - 6 цифр.
*/

public class LoanApplicationRequestDTO {
	private String firstName;
	private String lastName;
	private String middleName;
	/**
	 * Сумма кредита
	 */
	private BigDecimal amount;
	/**
	 * Срок кредита
	 */
	private Integer term;
	private LocalDate birthdate;
	private String email;
	private String passportSeries;
	private String passportNumber;


}
