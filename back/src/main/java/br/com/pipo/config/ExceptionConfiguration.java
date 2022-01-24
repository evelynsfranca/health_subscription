package br.com.pipo.config;

import br.com.pipo.service.exception.BadRequestException;
import br.com.pipo.service.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@ResponseBody
public class ExceptionConfiguration {

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleException(BadRequestException exception) {
        return String.format(
            "{\n" +
            "   \"status\": \"%s\"\n" +
            "   \"error\": \"%s\"\n" +
            "   \"message\": \"%s\"" +
            "}",
            HttpStatus.BAD_REQUEST.value(),
            HttpStatus.BAD_REQUEST.getReasonPhrase(),
            exception.getMessage());
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleException(NotFoundException exception) {
        return String.format(
            "{\n" +
            "   \"status\": \"%s\"\n" +
            "   \"error\": \"%s\",\n" +
            "   \"message\": \"%s\"\n" +
            "}",
            HttpStatus.NOT_FOUND.value(),
            HttpStatus.NOT_FOUND.getReasonPhrase(),
            exception.getMessage());
    }
}
