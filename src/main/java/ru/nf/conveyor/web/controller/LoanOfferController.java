package ru.nf.conveyor.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.nf.conveyor.model.LoanApplicationRequestDTO;
import ru.nf.conveyor.model.LoanOfferDTO;
import ru.nf.conveyor.service.CalculationLoanService;
import ru.nf.conveyor.service.PrescoringService;

import java.util.List;

/**
 * Контроллер для кредитных предложений
 */
@Slf4j
@RestController
@RequiredArgsConstructor
public class LoanOfferController implements LoanOfferApi {

	/**
	 * Сервис для работы с прескорингом
	 */
	private final PrescoringService prescoringService;

	/**
	 * Сервис для расчета кредитных предложений
	 */
	private final CalculationLoanService calculationLoanService;

	/**
	 * Метод для получения кредитных предложений
	 */
	@Override
	public List<LoanOfferDTO> offers(LoanApplicationRequestDTO loanApplicationRequestDTO) {
		log.info("LoanApplicationRequestDTO: {}", loanApplicationRequestDTO);

		//прекскоринг
		prescoringService.validate(loanApplicationRequestDTO);

		return calculationLoanService.calcLoan(loanApplicationRequestDTO);
	}
}
