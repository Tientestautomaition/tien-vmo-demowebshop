package com.vmo.demowebshop.interfaces;

public class LoginPageUI {

    public static final String LOGIN_TAG = "//div[@class='header-links']//a[@class='ico-login']";
    public static final String USERNAME_TXT = "//input[@id='Email']";
    public static final String PASSWORD_TXT = "//input[@id='Password']";
    public static final String LOGIN_BTN = "//input[@value='Log in']";
    public static String EXPECTED_MSG = "//*[contains(text(),'$')]]";
}