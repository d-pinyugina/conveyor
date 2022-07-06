package ru.nf.conveyor.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.nf.conveyor.model.LoanApplicationRequestDTO;

/**
 * Сервис для проверки прескоринга
 */
@Slf4j
@Service
public class PrescoringServiceImpl implements PrescoringService {
	@Override
	public void validate(LoanApplicationRequestDTO loanApplicationRequestDTO) {
		log.info("loanApplicationRequestDTO: {}", loanApplicationRequestDTO);
	}
}
