package ru.nf.conveyor.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

/**
 * Глобальный обработчик исключений
 */

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ResponseErrorDTO> errorResponseHandler(Exception exception){

		ResponseErrorDTO responseErrorDTO = ResponseErrorDTO.builder()
				.timestamp(LocalDateTime.now())
				.message(exception.getMessage())
				.build();
		return new ResponseEntity<>(responseErrorDTO, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
