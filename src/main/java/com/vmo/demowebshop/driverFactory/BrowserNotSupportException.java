package com.vmo.demowebshop.driverFactory;

public class BrowserNotSupportException extends IllegalStateException{
    private static final long serialVersionUID = 1L;
    public BrowserNotSupportException(String browserName){
        super(String.format("Browser not supported : %$",browserName));
    }}
