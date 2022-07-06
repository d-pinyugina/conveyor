package ru.nf.conveyor.web.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.nf.conveyor.model.LoanApplicationRequestDTO;
import ru.nf.conveyor.model.LoanOfferDTO;

import java.util.List;

/**
 * Интурфейс для кредитных предложений
 */

@RequestMapping(value = "/conveyor")
public interface LoanOfferApi {
	@GetMapping(value = "/{name}")
	String getName(@PathVariable String name);

	@PostMapping(value = "/offers", consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	List<LoanOfferDTO> offers(@RequestBody LoanApplicationRequestDTO loanApplicationRequestDTO);
}
