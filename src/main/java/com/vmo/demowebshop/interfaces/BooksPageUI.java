package com.vmo.demowebshop.interfaces;

public class BooksPageUI {
    public static final String BOOK_TAG = "//ul[@class='top-menu']//a[contains(text(),'Books')]";
    public static final String BOOKS_PRODUCT1 = "//div[@class='product-rating-box']";
    public static final String BOOK_DYNAMIC = "//div[@title='$']/following-sibling::div[@class='add-info']//input[@value='Add to cart']";
    public static final String ADD_TO_CART_SUCCESS_MSG = "//p[@class='content']";
    public static final String SHOPPING_CART_TAG = "//a[@class='ico-cart']//span[@class='cart-label']";
    public static final String BOOKS_PRODUCT_ADDED = "//div[@class='name']//a";
    public static final String BOOKS_PRODUCT_NAME = "//div[@title='$']/preceding-sibling::h2/a";


}
