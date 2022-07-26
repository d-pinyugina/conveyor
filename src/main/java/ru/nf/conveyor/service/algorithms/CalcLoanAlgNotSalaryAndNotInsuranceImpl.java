package ru.nf.conveyor.service.algorithms;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.nf.conveyor.model.LoanApplicationRequestDTO;
import ru.nf.conveyor.model.LoanOfferDTO;

/**
 * Сервис для расчета кредитного предложения по шаблону 1
 * isSalaryClient = false, isInsuranceEnabled = false
 */
@Slf4j
@Service
public class CalcLoanAlgNotSalaryAndNotInsuranceImpl implements CalcLoanAlgBase {

	/**
	 * Метод для расчета кредитного предложения
	 * isSalaryClient = false, isInsuranceEnabled = false
	 * @param request запрос
	 * @return кредитное предложение
	 */
	@Override
	public LoanOfferDTO getLoanOffer(LoanApplicationRequestDTO request) {
		log.info("request: {}", request);
		LoanOfferDTO loanOfferDTO = new LoanOfferDTO();
		loanOfferDTO.setIsSalaryClient(false);
		loanOfferDTO.setIsInsuranceEnabled(false);
		// расчет кредитной ставки

		return loanOfferDTO;
	}
}
