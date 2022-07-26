package ru.nf.conveyor.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.nf.conveyor.configuration.properties.ConveyorProperties;
import ru.nf.conveyor.model.LoanApplicationRequestDTO;
import ru.nf.conveyor.model.LoanOfferDTO;
import ru.nf.conveyor.service.algorithms.CalcLoanAlgBase;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Сервис для расчета кредитных предложений
 */

@Slf4j
@Service
@RequiredArgsConstructor
public class CalculationLoanServiceImpl implements CalculationLoanService {

	/**
	 * Сервис для расчета кредитных предложений
	 */
	private final List<CalcLoanAlgBase> calcLoanAlgBaseList;

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

		return calcLoanAlgBaseList.stream()
				.map(calcLoanAlgBase -> calcLoanAlgBase.getLoanOffer(request)).collect(Collectors.toList());
	}
}
