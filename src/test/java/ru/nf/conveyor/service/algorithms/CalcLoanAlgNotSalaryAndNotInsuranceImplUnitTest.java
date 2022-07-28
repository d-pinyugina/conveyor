package ru.nf.conveyor.service.algorithms;

import net.bytebuddy.utility.visitor.LocalVariableAwareMethodVisitor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.nf.conveyor.configuration.properties.ConveyorProperties;
import ru.nf.conveyor.model.LoanApplicationRequestDTO;
import ru.nf.conveyor.model.LoanOfferDTO;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = CalcLoanTestConfiguration.class)
public class CalcLoanAlgNotSalaryAndNotInsuranceImplUnitTest {

	@Autowired
	CalcLoanAlgNotSalaryAndNotInsuranceImpl calcLoanAlgNotSalaryAndNotInsurance;

	@Test
	@DisplayName("Проверка кредитного предложения 1: isSalaryClient = false, isInsuranceEnabled = false")
	void CalcLoanAlgNotSalaryAndNotInsuranceSuccess() {

		//GIVEN
		LoanApplicationRequestDTO requestDTO = new LoanApplicationRequestDTO();
		requestDTO.setTerm(7);

		//WHEN
		LoanOfferDTO loanOffer = calcLoanAlgNotSalaryAndNotInsurance.getLoanOffer(requestDTO);

		//THEN
		Assertions.assertEquals(7,loanOffer.getTerm());

	}
}
