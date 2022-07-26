package ru.nf.conveyor.service.algorithms;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.nf.conveyor.configuration.properties.ConveyorProperties;
import ru.nf.conveyor.model.LoanApplicationRequestDTO;
import ru.nf.conveyor.model.LoanOfferDTO;

/**
 * Сервис для расчета кредитного предложения по шаблону 4
 * isSalaryClient = true, isInsuranceEnabled = true
 */

@Slf4j
@Service
@RequiredArgsConstructor
public class CalcLoanAlgSalaryAndInsuranceImpl implements CalcLoanAlgBase{

	/**
	 * Класс, содержащий настройки для конвеера из файла application.yml
	 */
	private final ConveyorProperties conveyorProperties;

	@Override
	public LoanOfferDTO getLoanOffer(LoanApplicationRequestDTO request) {
		LoanOfferDTO loanOfferDTO = new LoanOfferDTO();
		loanOfferDTO.setIsSalaryClient(true);
		loanOfferDTO.setIsInsuranceEnabled(true);
		// расчет кредитной ставки --> базовая ставка 15%
		loanOfferDTO.setRate(conveyorProperties.getBaseRate());

		return loanOfferDTO;
	}
}
