package ru.nf.conveyor.service.algorithms;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.nf.conveyor.model.LoanApplicationRequestDTO;
import ru.nf.conveyor.model.LoanOfferDTO;

/**
 * Сервис для расчета кредитного предложения по шаблону 2
 * isSalaryClient = false, isInsuranceEnabled = true
 */

@Slf4j
@Service
public class CalcLoanAlgNotSalaryAndInsuranceImpl implements CalcLoanAlgBase {

	/**
	 * Метод для расчета кредитного предложения
	 * isSalaryClient = false, isInsuranceEnabled = true
	 * @param request запрос
	 * @return кредитное предложение
	 */
	@Override
	public LoanOfferDTO getLoanOffer(LoanApplicationRequestDTO request) {

		LoanOfferDTO loanOfferDTO = new LoanOfferDTO();
		loanOfferDTO.setIsSalaryClient(false);
		loanOfferDTO.setIsInsuranceEnabled(true);
		// расчет кредитной ставки

		return loanOfferDTO;
	}
}
