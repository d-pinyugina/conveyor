package ru.nf.conveyor.web.controller;

import jdk.jfr.ContentType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.nf.conveyor.model.LoanApplicationRequestDTO;
import ru.nf.conveyor.model.LoanOfferDTO;

import java.util.List;

@Slf4j
@RestController

/**
 * Контроллер для кредитных предложений
 */
public class LoanOfferController implements LoanOfferApi {
	/**
	 * Метод для получения имени
	 */
	@Override
	public String getName(String name) {
		log.info("Input name: {}", name);
		return name + "Ok";
	}

	/**
	 * Метод для получения кредитных предложений
	 */
	@Override
	public List<LoanOfferDTO> offers(LoanApplicationRequestDTO loanApplicationRequestDTO) {
		log.info("LoanApplicationRequestDTO: {}", loanApplicationRequestDTO);
		// маппинг
		LoanOfferDTO loanOfferDTO = new LoanOfferDTO();
		loanOfferDTO.setIsSalaryClient(true);
		return List.of(loanOfferDTO);
	}
}
