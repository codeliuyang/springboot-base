package com.lerr.demo.exception;

import com.lerr.demo.core.HttpResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * -
 *
 * @auther: yangliu
 * create date: 12-06-2019
 */
@ControllerAdvice
@Slf4j
public class ExceptionHandlerCentre {

    @ExceptionHandler(value = CommonBusinessException.class)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public HttpResult handleMostException(CommonBusinessException e){
        log.error("error happen", e);
        return HttpResult.error(e.getMessage());
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public HttpResult handleMostException(Exception e){
        log.error("error happen", e);
        return HttpResult.error("error happen" + e.getMessage());
    }

}
