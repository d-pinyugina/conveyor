package ru.nf.conveyor.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.nf.conveyor.model.LoanApplicationRequestDTO;
import ru.nf.conveyor.model.LoanOfferDTO;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class LoanOfferOperationServiceImpl implements LoanOfferBusinessOperationService{

	/**
	 * Сервис для работы с прескорингом
	 */
	private final PrescoringService prescoringService;

	/**
	 * Сервис для расчета кредитных предложений
	 */
	private final CalculationLoanService calculationLoanService;


	@Override
	public List<LoanOfferDTO> offers(LoanApplicationRequestDTO loanApplicationRequestDTO) {
		// прескоринг
		prescoringService.validate(loanApplicationRequestDTO);

		// расчет кредитных предложений
		calculationLoanService.calcLoan(loanApplicationRequestDTO);

		return calculationLoanService.calcLoan(loanApplicationRequestDTO);
	}
}
