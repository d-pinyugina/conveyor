package ru.nf.conveyor.service.algorithms;

import ru.nf.conveyor.model.LoanApplicationRequestDTO;
import ru.nf.conveyor.model.LoanOfferDTO;

/**
 * Интерфейс базового алгоритма для расчета кредитного предложения
 */
public interface CalcLoanAlgBase {

	LoanOfferDTO getLoanOffer(LoanApplicationRequestDTO request);
}
