package dev.nishant.productservicejan25.advices;

import dev.nishant.productservicejan25.dtos.errorDto;
import dev.nishant.productservicejan25.exceptions.productNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class controllerAdvice {

    @ExceptionHandler(productNotFoundException.class)
    public ResponseEntity<errorDto> handleProductNotFoundExecption(productNotFoundException productNotFoundException) {
        errorDto errorDto = new errorDto();
        errorDto.setMessage(productNotFoundException.getMessage());
        ResponseEntity<errorDto> responseEntity = new ResponseEntity<>(errorDto, HttpStatus.NOT_FOUND);
        return responseEntity;
    }

}
