package ru.nf.conveyor.service;

import ru.nf.conveyor.model.LoanApplicationRequestDTO;
import ru.nf.conveyor.model.LoanOfferDTO;

import java.util.List;

/**
 * Интерфейс сервиса операций кредитных предложений
 */

public interface LoanOfferBusinessOperationService {

	List<LoanOfferDTO> offers (LoanApplicationRequestDTO loanApplicationRequestDTO);
}
