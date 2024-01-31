package com.viktorkuts.cardealershipws.utils;

import com.viktorkuts.cardealershipws.utils.exceptions.HttpErrorInfo;
import com.viktorkuts.cardealershipws.utils.exceptions.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@Slf4j
@RestControllerAdvice
public class GlobalControllerExceptionHandler {
    private HttpErrorInfo createHttpErrorInfo(HttpStatus httpStatus, WebRequest request, Exception ex){
        final String path = request.getDescription(false);
        final String message = ex.getMessage();
        log.debug("[ HttpErrorInfo ] {}: {} ({})", httpStatus, message, path);
        return new HttpErrorInfo(httpStatus, path, message);
    }
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public HttpErrorInfo handleNotFound(WebRequest request, Exception ex){
        return createHttpErrorInfo(HttpStatus.NOT_FOUND, request, ex);
    }
}
