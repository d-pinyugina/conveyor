package ru.nf.conveyor.service;

import ru.nf.conveyor.model.LoanApplicationRequestDTO;

/**
 * Интерфейс сервиса для проверки входящих запросов
 */
public interface PrescoringService {
	/**
	 * Валидация входящего запроса
	 *
	 * @param loanApplicationRequestDTO входящий запрос
	 */
	void validate(LoanApplicationRequestDTO loanApplicationRequestDTO);
}
