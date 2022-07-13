package ru.nf.conveyor.service;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.nf.conveyor.model.LoanApplicationRequestDTO;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Правила прескоринга
 * Имя, Фамилия - от 2 до 30 латинских букв. Отчество, при наличии - от 2 до 30 латинских букв.
 * Сумма кредита - действительно число, большее или равное 10000.
 * Срок кредита - целое число, большее или равное 6.
 * Дата рождения - число в формате гггг-мм-дд, не позднее 18 лет с текущего дня.
 * Email адрес - строка, подходящая под паттерн [\w\.]{2,50}@[\w\.]{2,20}
 * Серия паспорта - 4 цифры, номер паспорта - 6 цифр.
 */

/**
 * Сервис для проверки прескоринга
 */
@Slf4j
@Service
public class PrescoringServiceImpl implements PrescoringService {

	/**
	 * Имя может содержать от 2 до 30 символов.
	 * Имя может начинаться только с символа az (без учета регистра).
	 * После этого имя может содержать az (без учета регистра) и ['-,.].
	 * Имя может заканчиваться только символом az (без учета регистра).
	 */
	private static final String NAME_PATTERN =
			"(?i)(^[a-z]+)[a-z .,-]((?! .,-)$){2,30}$";


	/**
	 * Константа, описывающая регулярное выражение для валидации email
	 */
	private static final String EMAIL_PATTERN = "[\\w\\.]{2,50}@[\\w\\.]{2,20}";

	/**
	 * Константа, описывающая регулярное выражение для валидации серии паспорта
	 */
	private static final String PASSPORT_SERIES_PATTERN = "^([0-9]{4})?$";

	/**
	 * Константа, описывающая регулярное выражение для валидации номера паспорта
	 */
	private static final String PASSPORT_NUMBER = "^([0-9]{6})?$";

	@Override
	public void validate(LoanApplicationRequestDTO loanApplicationRequestDTO) {
		log.info("loanApplicationRequestDTO: {}", loanApplicationRequestDTO);

		//проверка имени (от 2 до 30 латинских букв)
		firstNameValidation(loanApplicationRequestDTO.getFirstName());

		//проверка фамилии (от 2 до 30 латинских букв)
		lastNameValidation(loanApplicationRequestDTO.getLastName());

		//проверка отчества (при наличии - от 2 до 30 латинских букв)
		middleNameValidation(loanApplicationRequestDTO.getMiddleName());

		// проверка суммы кредита
		amountValidation(loanApplicationRequestDTO.getAmount());

		//проверка срока кредита (целое число, большее или равное 6)
		termValidation(loanApplicationRequestDTO.getTerm());

		//проверка даты рождения (число в формате гггг-мм-дд, не позднее 18 лет с текущего дня)
		birthDateValidation(loanApplicationRequestDTO.getBirthDate());

		//проверка почты (Email адрес - строка, подходящая под паттерн [\w\.]{2,50}@[\w\.]{2,20})
		emailValidation(loanApplicationRequestDTO.getEmail());

		//проверка серии паспорта (4 цифры), номера паспорта (6 цифр)
		passportSeriesValidation(loanApplicationRequestDTO.getPassportSeries());

		passportNumberValidation(loanApplicationRequestDTO.getPassportNumber());

		log.info("validation success");
	}

	private void firstNameValidation(@NonNull String firstName) {
		log.info("first name validation {}", firstName);

		Pattern firstNamePat = Pattern.compile(NAME_PATTERN, Pattern.CASE_INSENSITIVE);
		Matcher matcher = firstNamePat.matcher(firstName);

		if (!matcher.find()) {
			throw new IllegalArgumentException("firstName не соответствует шаблону");
		}
	}

	private void lastNameValidation(@NonNull String lastName) {
		log.info("last name validation {}", lastName);

		Pattern lastNamePat = Pattern.compile(NAME_PATTERN, Pattern.CASE_INSENSITIVE);
		Matcher matcher = lastNamePat.matcher(lastName);

		if (!matcher.find()) {
			throw new IllegalArgumentException("lastName не соответствует шаблону");
		}
	}

	private void middleNameValidation(@NonNull String middleName) {
		log.info("middle name validation {}", middleName);

		Pattern middleNamePat = Pattern.compile(NAME_PATTERN, Pattern.CASE_INSENSITIVE);
		Matcher matcher = middleNamePat.matcher(middleName);

		if (!matcher.find()) {
			throw new IllegalArgumentException("middleName не соответствует шаблону");
		}
	}

	private void amountValidation(@NonNull BigDecimal amount) {
		log.info("Amount validation {}", amount);

		BigDecimal amountMin = new BigDecimal("10000");

		if (amount.compareTo(amountMin) < 0) {
			throw new IllegalArgumentException("amount меньше 10000");
		}
	}

	private void termValidation(@NonNull Integer term) {
		log.info("term validation {}", term);

		if (term < 6) {
			throw new IllegalArgumentException("Срок кредита указан неверно");
		}
	}

	private void birthDateValidation(@NonNull LocalDate birthDate) {
		log.info("birth date validation {}", birthDate);
		Period between = Period.between(birthDate, LocalDate.now());
		int years = between.getYears();

		if (years < 18) {
			throw new IllegalArgumentException("birth date не соответствует требованиям. Вам должно быть 18 лет!");
		}
	}

	private void emailValidation(@NonNull String email) {
		log.info("email validation {}", email);

		Pattern emailPat = Pattern.compile(EMAIL_PATTERN, Pattern.CASE_INSENSITIVE);
		Matcher matcher = emailPat.matcher(email);

		if (!matcher.find()) {
			throw new IllegalArgumentException("email не соответствует шаблону");
		}
	}

	private void passportSeriesValidation(@NonNull String series) {
		log.info("passport series {} validation", series);

		Pattern passportSeriesPat = Pattern.compile(PASSPORT_SERIES_PATTERN, Pattern.CASE_INSENSITIVE);
		Matcher matcher = passportSeriesPat.matcher(series);

		if (!matcher.find()) {
			throw new IllegalArgumentException("passportSeries не соответствует шаблону");
		}
	}

	private void passportNumberValidation(@NonNull String number) {
		log.info("Success passport series {} validation", number);

		Pattern passportNumberPat = Pattern.compile(PASSPORT_NUMBER, Pattern.CASE_INSENSITIVE);
		Matcher matcher = passportNumberPat.matcher(number);

		if (!matcher.find()) {
			throw new IllegalArgumentException("passportSeries не соответствует шаблону");
		}
	}
}
