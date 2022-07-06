package ru.nf.conveyor.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.nf.conveyor.model.LoanApplicationRequestDTO;

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

		if (loanApplicationRequestDTO.getEmail() == null) {
			throw new IllegalArgumentException("Не заполнена почта");
		}
	}
}
