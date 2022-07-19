package ru.nf.conveyor.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.nf.conveyor.configuration.properties.ConveyorProperties;
import ru.nf.conveyor.model.LoanApplicationRequestDTO;
import ru.nf.conveyor.model.LoanOfferDTO;

import java.util.List;

/**
 * Сервис для расчета кредитных предложений
 */

@Slf4j
@Service
@RequiredArgsConstructor
public class CalculationLoanServiceImpl implements CalculationLoanService {


	private final ConveyorProperties properties;

	/**
	 * На основании LoanApplicationRequestDTO происходит прескоринг (п.5.1)
	 * создаётся 4 кредитных предложения LoanOfferDTO на основании всех возможных комбинаций булевских
	 * полей isInsuranceEnabled и isSalaryClient (false-false, false-true, true-false, true-true).
	 * Логику формирования кредитных предложений можно придумать самому.
	 * К примеру: в зависимости от страховых услуг увеличивается/уменьшается процентная ставка и сумма кредита,
	 * базовая ставка хардкодится в коде через property файл. Например цена страховки 100к (или прогрессивная,
	 * в зависимости от запрошенной суммы кредита), ее стоимость добавляется в тело кредита, но она уменьшает ставку на 3.
	 * Цена зарплатного клиента 0, уменьшает ставку на 1.
	 * Ответ на API - список из 4х LoanOfferDTO от "худшего" к "лучшему" (чем меньше итоговая ставка, тем лучше).
	 */

	@Override
	public List<LoanOfferDTO> calcLoan(LoanApplicationRequestDTO request) {

		// 1 isSalaryClient = false, isInsuranceEnabled = false
		// 2 isSalaryClient = false, isInsuranceEnabled = true
		// 3 isSalaryClient = true, isInsuranceEnabled = false
		// 4 isSalaryClient = true, isInsuranceEnabled = true
		return null;
	}

	private LoanOfferDTO getLoanOfferDTOByAlg1(LoanApplicationRequestDTO request) {
		LoanOfferDTO loanOfferDTO = new LoanOfferDTO();
		loanOfferDTO.setIsSalaryClient(false);
		loanOfferDTO.setIsInsuranceEnabled(false);
		// расчет кредитной ставки

		return loanOfferDTO;
	}

	private LoanOfferDTO getLoanOfferDTOByAlg2(LoanApplicationRequestDTO request) {
		LoanOfferDTO loanOfferDTO = new LoanOfferDTO();
		loanOfferDTO.setIsSalaryClient(false);
		loanOfferDTO.setIsInsuranceEnabled(true);
		// расчет кредитной ставки

		return loanOfferDTO;
	}

	private LoanOfferDTO getLoanOfferDTOByAlg3(LoanApplicationRequestDTO request) {
		LoanOfferDTO loanOfferDTO = new LoanOfferDTO();
		loanOfferDTO.setIsSalaryClient(true);
		loanOfferDTO.setIsInsuranceEnabled(false);
		// расчет кредитной ставки

		return loanOfferDTO;
	}

	private LoanOfferDTO getLoanOfferDTOByAlg4(LoanApplicationRequestDTO request) {
		LoanOfferDTO loanOfferDTO = new LoanOfferDTO();
		loanOfferDTO.setIsSalaryClient(true);
		loanOfferDTO.setIsInsuranceEnabled(true);
		// расчет кредитной ставки --> базовая ставка 15%
		loanOfferDTO.setRate(properties.getBaseRate());

		return loanOfferDTO;
	}

	/**
	 * Метод для расчета ежемесячного платежа
	 *
	 * @param amount    сумма кредита
	 * @param monthRate процентная ставка за месяц
	 * @param period    период
	 * @return платеж
	 */
	private Double calcPen(Double amount, Double monthRate, Integer period) {

		return amount * monthRate / (1 - (Math.pow(1 + monthRate, (-1) * period)));
	}
}
