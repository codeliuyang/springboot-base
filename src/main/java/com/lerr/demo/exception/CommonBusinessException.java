package com.lerr.demo.exception;

/**
 * -
 *
 * @auther: yangliu
 * create date: 12-06-2019
 */
public class CommonBusinessException extends RuntimeException {

    public CommonBusinessException(){
        super();
    }

    public CommonBusinessException(String message){
        super(message);
    }

}
