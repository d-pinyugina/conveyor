package ru.nf.conveyor.service.algorithms;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.nf.conveyor.model.LoanApplicationRequestDTO;
import ru.nf.conveyor.model.LoanOfferDTO;
import ru.nf.conveyor.utils.CalcPenUtil;

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
	 *
	 * @param request запрос
	 * @return кредитное предложение
	 */
	@Override
	public LoanOfferDTO getLoanOffer(LoanApplicationRequestDTO request) {
		log.info("request: {}", request);
		LoanOfferDTO loanOfferDTO = new LoanOfferDTO();
		loanOfferDTO.setTerm(request.getTerm());
		loanOfferDTO.setTotalAmount(13000.00);
		loanOfferDTO.setRequestedAmount(13000.00);
		// ставка по кредиту/(100*12) -> ежемесячная % ставка
		loanOfferDTO.setMonthlyPayment(CalcPenUtil.calcPen(13000.00, 0.0166, 7));
		loanOfferDTO.setRate(20.00);
		loanOfferDTO.setIsSalaryClient(false);
		loanOfferDTO.setIsInsuranceEnabled(false);

		return loanOfferDTO;
	}
}
