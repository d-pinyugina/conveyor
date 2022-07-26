package ru.nf.conveyor.service.algorithms;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.nf.conveyor.configuration.properties.ConveyorProperties;
import ru.nf.conveyor.model.LoanApplicationRequestDTO;
import ru.nf.conveyor.model.LoanOfferDTO;
import ru.nf.conveyor.utils.CalcPenUtil;

import java.math.BigDecimal;

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
	 *
	 * @param request запрос
	 * @return кредитное предложение
	 */
	@Override
	public LoanOfferDTO getLoanOffer(LoanApplicationRequestDTO request) {

		LoanOfferDTO loanOfferDTO = new LoanOfferDTO();
		loanOfferDTO.setTerm(request.getTerm());
		loanOfferDTO.setTotalAmount(12000.00);
		loanOfferDTO.setRequestedAmount(12000.00);
		// ставка по кредиту/(100*12) -> ежемесячная % ставка
		loanOfferDTO.setMonthlyPayment(CalcPenUtil.calcPen(12000.00, 0.0141, 7));
		loanOfferDTO.setRate(17.00);
		loanOfferDTO.setIsSalaryClient(false);
		loanOfferDTO.setIsInsuranceEnabled(true);

		return loanOfferDTO;
	}
}
