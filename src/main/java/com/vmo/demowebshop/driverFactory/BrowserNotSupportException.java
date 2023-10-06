package com.vmo.nopcommerce.driverFactory;

public class BrowserNotSupportException extends IllegalStateException{
    private static final long serialVersionUID = 1L;
    public BrowserNotSupportException(String browsername){
        super(String.format("Browser not supported : %$",browsername));
    }}
