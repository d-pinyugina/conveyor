package ru.nf.conveyor.model;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonTypeName("offers")
@Data
public class LoanOfferDTO {
	private String status;
}
