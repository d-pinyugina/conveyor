package ru.nf.conveyor.service;

import ru.nf.conveyor.model.LoanApplicationRequestDTO;
import ru.nf.conveyor.model.LoanOfferDTO;

import java.util.List;

/**
 * Интерфейс для расчета кредитных предложений
 */

public interface CalculationLoanService {

	List<LoanOfferDTO> calcLoan(LoanApplicationRequestDTO request);

}
