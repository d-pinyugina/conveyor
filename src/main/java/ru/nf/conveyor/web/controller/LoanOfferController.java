package ru.nf.conveyor.web.controller;
import jdk.jfr.ContentType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.nf.conveyor.model.LoanApplicationRequestDTO;
import ru.nf.conveyor.model.LoanOfferDTO;

@Slf4j
@RestController
@RequestMapping(value="/conveyor")
public class LoanOfferController {

	@GetMapping(value="/{name}")
	public String getName(@PathVariable String name){
		log.info("Input name: {}", name);
		return name + "Ok";
	}

	@PostMapping(value ="/offers", consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public LoanOfferDTO offers (@RequestBody LoanApplicationRequestDTO loanApplicationRequestDTO){
		log.info("LoanApplicationRequestDTO: {}",loanApplicationRequestDTO);
		//маппинг
		LoanOfferDTO loanOfferDTO = new LoanOfferDTO();
		loanOfferDTO.setStatus("Super");
		return loanOfferDTO;
	}

}
