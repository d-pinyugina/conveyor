package ru.nf.conveyor.service.algorithms;

import net.bytebuddy.utility.visitor.LocalVariableAwareMethodVisitor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.nf.conveyor.configuration.properties.ConveyorProperties;
import ru.nf.conveyor.model.LoanApplicationRequestDTO;
import ru.nf.conveyor.model.LoanOfferDTO;

@SpringBootTest
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
		requestDTO.setAmount(15000.00);

		//WHEN
		LoanOfferDTO loanOffer = calcLoanAlgNotSalaryAndNotInsurance.getLoanOffer(requestDTO);

		//THEN
		Assertions.assertNotNull(loanOffer);
		Assertions.assertEquals(7, loanOffer.getTerm());
		Assertions.assertEquals(2289.0, loanOffer.getMonthlyPayment());
		Assertions.assertEquals(false,loanOffer.getIsSalaryClient());
		Assertions.assertEquals(false,loanOffer.getIsInsuranceEnabled());
		Assertions.assertEquals(15000,loanOffer.getRequestedAmount());
		Assertions.assertEquals(32523.0,loanOffer.getTotalAmount());
		Assertions.assertEquals(20,loanOffer.getRate());
	}
}
