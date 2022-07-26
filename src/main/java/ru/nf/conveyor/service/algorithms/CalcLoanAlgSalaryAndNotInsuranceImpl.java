package ru.nf.conveyor.service.algorithms;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.nf.conveyor.model.LoanApplicationRequestDTO;
import ru.nf.conveyor.model.LoanOfferDTO;

/**
 * Сервис для расчета кредитного предложения по шаблону 3
 * isSalaryClient = true, isInsuranceEnabled = false
 */

@Slf4j
@Service
public class CalcLoanAlgSalaryAndNotInsuranceImpl implements CalcLoanAlgBase{

	/**
	 * Метод для расчета кредитного предложения
	 * isSalaryClient = true, isInsuranceEnabled = false
	 * @param request запрос
	 * @return кредитное предложение
	 */
	@Override
	public LoanOfferDTO getLoanOffer(LoanApplicationRequestDTO request) {

		LoanOfferDTO loanOfferDTO = new LoanOfferDTO();
		loanOfferDTO.setIsSalaryClient(true);
		loanOfferDTO.setIsInsuranceEnabled(false);
		// расчет кредитной ставки

		return loanOfferDTO;
	}
}
