package ru.nf.conveyor.service.algorithms;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.nf.conveyor.model.LoanApplicationRequestDTO;
import ru.nf.conveyor.model.LoanOfferDTO;
import ru.nf.conveyor.utils.CalcPenUtil;

/**
 * Сервис для расчета кредитного предложения по шаблону 3
 * isSalaryClient = true, isInsuranceEnabled = false
 */

@Slf4j
@Service
public class CalcLoanAlgSalaryAndNotInsuranceImpl implements CalcLoanAlgBase {

	/**
	 * Метод для расчета кредитного предложения
	 * isSalaryClient = true, isInsuranceEnabled = false
	 *
	 * @param request запрос
	 * @return кредитное предложение
	 */
	@Override
	public LoanOfferDTO getLoanOffer(LoanApplicationRequestDTO request) {

		LoanOfferDTO loanOfferDTO = new LoanOfferDTO();
		loanOfferDTO.setTerm(request.getTerm());
		loanOfferDTO.setTotalAmount(10000.00);
		loanOfferDTO.setRequestedAmount(10000.00);
		// ставка по кредиту/(100*12) -> ежемесячная % ставка
		loanOfferDTO.setMonthlyPayment(CalcPenUtil.calcPen(10000.00, 0.015, 7));
		loanOfferDTO.setRate(18.00);
		loanOfferDTO.setIsSalaryClient(true);
		loanOfferDTO.setIsInsuranceEnabled(false);

		return loanOfferDTO;
	}
}
