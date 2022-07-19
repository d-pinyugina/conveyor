package ru.nf.conveyor.service;

import ru.nf.conveyor.model.LoanApplicationRequestDTO;
import ru.nf.conveyor.model.LoanOfferDTO;

import java.util.List;

/**
 * Интерфейс сервиса операций кредитных предложений
 */

public interface LoanOfferBusinessOperationService {

	/**
	 * Метод, который возвращает операции по кредитным предложениям
	 *
	 * @param loanApplicationRequestDTO запрос
	 */
	List<LoanOfferDTO> offers(LoanApplicationRequestDTO loanApplicationRequestDTO);
}
