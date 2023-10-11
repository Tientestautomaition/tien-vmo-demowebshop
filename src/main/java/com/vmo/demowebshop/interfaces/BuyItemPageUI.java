package com.vmo.demowebshop.interfaces;

public class BuyItemPageUI {
    public static final String ADD_TO_CART_PRODUCT_BTN = "(//input[@value='Add to cart'])[2]";
    public static final String ADD_TO_CART_SUCCESS_MSG = "//p[@class='content']";
    public static final String DIGITAL_DOWNLOAD_TAG = "//ul[@class='top-menu']//a[contains(text(),'Digital downloads')]";
    public static final String SHOPPING_CART_TAG = "//a[@class='ico-cart']//span[@class='cart-label']";
    public static final String SHOPPING_CART_QUANTITY = "//a[@class='ico-cart']//span[@class='cart-qty']";
    public static final String CHECKBOX_TERM_OF_SERVICE = "//input[@id='termsofservice']";
    public static final String CHECKBOX_BTN = "//button[@id='checkout']";
    public static final String CONTINUE_BTN = "//input[@onclick='$.save()']";
    public static final String CHECKBOX_AS_WEB_BTN = "//input[@value='Checkout as Guest']";
    public static final String EXPANDING_TAB = "//li[@id='opc-$']";
    public static final String BILLING_ADDRESS_TXT = "//input[@id='BillingNewAddress_$']";
    public static final String RADIO_BUTTON_PAYMENT_METHOD_CASH = "//input[@value='Payments.CashOnDelivery']";
    public static final String MSG_YOU_WILL_PAID_BY_COD = "//p[text()='You will pay by COD']";
    public static final String BILLING_ADDRESS_INFO = "//ul[@class='billing-info']//li[@class='$']";
    public static final String PAYMENT_METHOD_INFO = "//li[@class='payment-method']";
    public static final String PRODUCT_INFO = ".//a[@class='product-name']";
    public static final String SUB_TOTAL_PRODUCT = "(//span[@class='product-price'])[1]";
    public static final String PAYMENT_METHOD_ADD_FEE = "(//span[@class='product-price'])[2]";
    public static final String TOTAL_PRODUCT = "//span[@class='product-price order-total']//strong";
    public static final String MSG_ORDER_SUCCESS = "//div[@class='title']//strong";
    public static final String CONTINUE_COMPLETE_ORDER_BTN= "//input[@value='Continue']";



}
