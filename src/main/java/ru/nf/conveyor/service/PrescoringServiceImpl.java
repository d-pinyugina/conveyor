package ru.nf.conveyor.service;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.nf.conveyor.model.LoanApplicationRequestDTO;

import java.time.LocalDate;
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

	@Override
	public void validate(LoanApplicationRequestDTO loanApplicationRequestDTO) {
		log.info("loanApplicationRequestDTO: {}", loanApplicationRequestDTO);

		//проверка имени (от 2 до 30 латинских букв)
		firstNameValidation(loanApplicationRequestDTO.getFirstName());

		//проверка фамилии (от 2 до 30 латинских букв)
		lastNameValidation(loanApplicationRequestDTO.getLastName());

		//проверка отчества (при наличии - от 2 до 30 латинских букв)
		middleNameValidation(loanApplicationRequestDTO.getMiddleName());

		//проверка срока кредита (целое число, большее или равное 6)
		termValidation(loanApplicationRequestDTO.getTerm());

		//проверка даты рождения (число в формате гггг-мм-дд, не позднее 18 лет с текущего дня)
		birthDateValidation(loanApplicationRequestDTO.getBirthDate());

		//проверка почты (Email адрес - строка, подходящая под паттерн [\w\.]{2,50}@[\w\.]{2,20})
		emailValidation(loanApplicationRequestDTO.getEmail());

		//проверка серии паспорта (4 цифры), номера паспорта (6 цифр)
		passportSeriesValidation(loanApplicationRequestDTO.getPassportSeries());

		passporNumbertValidation(loanApplicationRequestDTO.getPassportNumber());

	}

	private boolean firstNameValidation(@NonNull String firstName) {
		log.info("Success first name validation {}", firstName);
/**
 * Имя может содержать от 2 до 30 символов.
 * Имя может начинаться только с символа az (без учета регистра).
 * После этого имя может содержать az (без учета регистра) и ['-,.].
 * Имя может заканчиваться только символом az (без учета регистра).
 */
		String firstNameRegex = "(?i)(^[a-z]+)[a-z .,-]((?! .,-)$){2,30}$";
		Pattern firstNamePat = Pattern.compile(firstNameRegex, Pattern.CASE_INSENSITIVE);
		Matcher matcher = firstNamePat.matcher(firstName);
		return matcher.find();
	}

	private boolean lastNameValidation(@NonNull String lastName) {
		log.info("Success last name validation {}", lastName);

		String lastNameRegex = "(?i)(^[a-z]+)[a-z .,-]((?! .,-)$){2,30}$";
		Pattern lastNamePat = Pattern.compile(lastNameRegex, Pattern.CASE_INSENSITIVE);
		Matcher matcher = lastNamePat.matcher(lastName);
		return matcher.find();
	}

	private boolean middleNameValidation(@NonNull String middleName) {
		log.info("Success middle name validation {}", middleName);

		String middleNameRegex = "(?i)(^[a-z]+)[a-z .,-]((?! .,-)$){2,30}$";
		Pattern middleNamePat = Pattern.compile(middleNameRegex, Pattern.CASE_INSENSITIVE);
		Matcher matcher = middleNamePat.matcher(middleName);
		return matcher.find();
	}

	private void termValidation(@NonNull Integer term) {
		log.info("Success term validation {}", term);

		if(term < 6){
			throw new IllegalArgumentException("Срок кредита указан неверно");
		}
	}

	private void birthDateValidation(@NonNull LocalDate birthDate) {
		log.info("Success birth date validation {}", birthDate);
	}

	private boolean emailValidation(@NonNull String email) {
		log.info("Success email validation {}", email);

		String emailRegex = "[\\w\\.]{2,50}@[\\w\\.]{2,20}";
		Pattern emailPat = Pattern.compile(emailRegex, Pattern.CASE_INSENSITIVE);
		Matcher matcher = emailPat.matcher(email);
		return matcher.find();
	}

	private boolean passportSeriesValidation(@NonNull String series) {
		log.info("Success passport series {} validation", series);

		String passportSeriesRegex = "^([0-9]{4})?$";
		Pattern passportSeriesPat = Pattern.compile(passportSeriesRegex, Pattern.CASE_INSENSITIVE);
		Matcher matcher = passportSeriesPat.matcher(series);
		return matcher.find();
	}

	private boolean passporNumbertValidation(@NonNull String number){
		log.info("Success passport series {} validation", number);

		String passportNumberRegex = "^([0-9]{6})?$";
		Pattern passportNumberPat = Pattern.compile(passportNumberRegex, Pattern.CASE_INSENSITIVE);
		Matcher matcher = passportNumberPat.matcher(number);
		return matcher.find();
	}
}
