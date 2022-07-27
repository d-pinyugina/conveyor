package ru.nf.conveyor.service.algorithms;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.nf.conveyor.configuration.properties.ConveyorProperties;
import ru.nf.conveyor.model.LoanApplicationRequestDTO;
import ru.nf.conveyor.model.LoanOfferDTO;
import ru.nf.conveyor.utils.CalcPenUtil;
import ru.nf.conveyor.utils.MonthlyRateUtil;

/**
 * Сервис для расчета кредитного предложения по шаблону 3
 * isSalaryClient = true, isInsuranceEnabled = false
 */

@Slf4j
@Service
@RequiredArgsConstructor
public class CalcLoanAlgSalaryAndNotInsuranceImpl implements CalcLoanAlgBase {

	/**
	 * Класс, содержащий настройки для конвеера из файла application.yml
	 */
	private final ConveyorProperties conveyorProperties;

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
		loanOfferDTO.setRequestedAmount(request.getAmount());
		// ставка по кредиту/(100*12) -> ежемесячная % ставка
		Double monthRate = MonthlyRateUtil.monthlyRate(conveyorProperties.getBaseRate() + 2);
		// ежемесячный платеж
		Double monthPay = CalcPenUtil.calcPen(
				request.getAmount(),
				monthRate,
				request.getTerm()
		);
		loanOfferDTO.setMonthlyPayment(monthPay);
		/**
		 * request.getAmount() * 1.1 --> страховка
		 */
		loanOfferDTO.setTotalAmount(Math.ceil(monthPay * request.getTerm() + request.getAmount() * 1.1));
		loanOfferDTO.setRate(conveyorProperties.getBaseRate() + 2);
		loanOfferDTO.setIsSalaryClient(true);
		loanOfferDTO.setIsInsuranceEnabled(false);

		return loanOfferDTO;
	}
}
