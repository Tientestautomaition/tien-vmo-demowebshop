package com.vmo.demowebshop.interfaces;

public class BuyItemPageUI {
    public static final String ADD_TO_CART_PRODUCT_BTN = "(//input[@value='Add to cart'])[2]";
    public static final String ADD_TO_CART_SUCCESS_MSG = "//p[@class='content']";
    public static final String DIGITAL_DOWNLOAD_TAG = "//ul[@class='top-menu']//a[contains(text(),'Digital downloads')]";
    public static final String SHOPPING_CART_TAG = "//a[@class='ico-cart']//span[@class='cart-label']";
    public static final String SHOPPING_CART_QUANTITY = "//a[@class='ico-cart']//span[@class='cart-qty']";
    public static final String CHECKBOX_TERM_OF_SERVICE = "//input[@id='termsofservice']";

    public static final String CHECKBOX_BTN = "//button[@id='checkout']";
    public static final String CHECKBOX_AS_WEB_BTN = "//input[@value='Checkout as Guest']";


}
