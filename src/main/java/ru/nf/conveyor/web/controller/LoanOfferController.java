package ru.nf.conveyor.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.nf.conveyor.model.LoanApplicationRequestDTO;
import ru.nf.conveyor.model.LoanOfferDTO;
import ru.nf.conveyor.service.CalculationLoanService;
import ru.nf.conveyor.service.LoanOfferBusinessOperationService;
import ru.nf.conveyor.service.PrescoringService;

import java.util.List;

/**
 * Контроллер для кредитных предложений
 */
@Slf4j
@RestController
@RequiredArgsConstructor
public class LoanOfferController implements LoanOfferApi {

	private final LoanOfferBusinessOperationService loanOfferBusinessOperationService;

	/**
	 * Метод для получения кредитных предложений
	 */
	@Override
	public List<LoanOfferDTO> offers(LoanApplicationRequestDTO loanApplicationRequestDTO) {
		log.info("LoanApplicationRequestDTO: {}", loanApplicationRequestDTO);

		return loanOfferBusinessOperationService.offers(loanApplicationRequestDTO);
	}
}
