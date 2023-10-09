package com.vmo.demowebshop.pageobject;

import com.vmo.demowebshop.common.BasePage;
import com.vmo.demowebshop.helper.Log;
import com.vmo.demowebshop.interfaces.BooksPageUI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BookPageObject extends BasePage {

    public BookPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public BookPageObject openHomepage(String url) {
        openUrl(driver, url);
        return this;
    }

    public BookPageObject verifyTitleHomePage(String expectedTitle) {
        Assert.assertEquals(getTitle(driver), expectedTitle);
        Log.info("Open Home page success");
        Log.allure("Open Home page success");
        return this;
    }

    public BookPageObject verifyTitleBookPage(String expectedTitle) {
        Assert.assertEquals(getTitle(driver), expectedTitle);
        Log.info("Open Book page success");
        Log.allure("Open Book page success");
        return this;
    }

    public BookPageObject clickToBookTag() {
        clickToElement(driver, BooksPageUI.BOOK_TAG);
        return this;
    }

    public BookPageObject clickOnBooksAddToCart() {
        List<WebElement> listElements = getListWebElements(driver, BooksPageUI.BOOKS_PRODUCT1);
        List<String> attributeValuesRate = new ArrayList<>();


        for (WebElement element : listElements) {
            String valueAttribute = element.getAttribute("title");
            attributeValuesRate.add(valueAttribute);
        }
        List<String> sortedAttributeValuesRate = new ArrayList<>(attributeValuesRate);
        Collections.sort(sortedAttributeValuesRate, Collections.reverseOrder());

        String highestRating1 = sortedAttributeValuesRate.get(0);
        String highestRating2 = sortedAttributeValuesRate.get(1);

        String xpathHighestRating1 = BooksPageUI.BOOK_DYNAMIC.replace("$", highestRating1);
        String xpathHighestRating2 = BooksPageUI.BOOK_DYNAMIC.replace("$", highestRating2);

        String cartQuantityText0 = getTextElement(driver, BooksPageUI.SHOPPING_CART_QUANTITY);
        int cartQuantity0 = Integer.parseInt(cartQuantityText0);

        clickToElement(driver,xpathHighestRating1 );

        String cartQuantityText1 = getTextElement(driver, BooksPageUI.SHOPPING_CART_QUANTITY);
        int cartQuantity1 = Integer.parseInt(cartQuantityText1);
        System.out.println("cartQuantity1 = " + cartQuantity1);
        Assert.assertEquals(cartQuantity1 - 1, cartQuantity0);
        sleepInSecond(2);

        clickToElement(driver, xpathHighestRating2);
        sleepInSecond(5);

        String cartQuantityText2 = getTextElement(driver, BooksPageUI.SHOPPING_CART_QUANTITY);
        int cartQuantity2 = Integer.parseInt(cartQuantityText2);
        Assert.assertEquals(cartQuantity2 - 1, cartQuantity1);
        sleepInSecond(2);
        System.out.println("cartQuantity0 = "+ cartQuantity0);
        System.out.println("cartQuantity1 = " + cartQuantity1);
        System.out.println("cartQuantity2 = " + cartQuantity2);

        return this;
    }

    public BookPageObject verifyAppearMsgAddProductToCartSuccess() {
        Assert.assertTrue(isElementDisplay(driver,BooksPageUI.ADD_TO_CART_SUCCESS_MSG));
        return this;
    }
    public BookPageObject hoverOnShoppingCartTag() {
        hoverMouseToElement(driver, BooksPageUI.SHOPPING_CART_TAG);
        sleepInSecond(5);
        return this;
    }
    public BookPageObject verifyProductAreAdded() {
        List<WebElement> listElements = getListWebElements(driver, BooksPageUI.BOOKS_PRODUCT1);
        List<String> attributeValuesRate = new ArrayList<>();

        for (WebElement element : listElements) {
            String valueAttribute = element.getAttribute("title");
            attributeValuesRate.add(valueAttribute);
        }
        List<String> sortedAttributeValuesRate = new ArrayList<>(attributeValuesRate);
        Collections.sort(sortedAttributeValuesRate, Collections.reverseOrder());

        String highestRating1 = sortedAttributeValuesRate.get(0);
        String highestRating2 = sortedAttributeValuesRate.get(1);

        String xpathHighestRating1 = BooksPageUI.BOOKS_PRODUCT_NAME.replace("$", highestRating1);
        String xpathHighestRating2 = BooksPageUI.BOOKS_PRODUCT_NAME.replace("$", highestRating2);
        String bookAdded1 = getTextElement(driver,xpathHighestRating1 );
        sleepInSecond(1);
        String bookAdded2 = getTextElement(driver,xpathHighestRating2 );
        sleepInSecond(1);
        List<String> nameBooksAdd = new ArrayList<>();
        nameBooksAdd.add(bookAdded1);
        nameBooksAdd.add(bookAdded2);
        List<WebElement> productElements = getListWebElements(driver, BooksPageUI.BOOKS_PRODUCT_ADDED);
        List<String> nameBooksAdded = new ArrayList<>();
        for (WebElement productElement : productElements) {
            String productName = productElement.getText();
            nameBooksAdded.add(productName);
        }
        Collections.reverse(nameBooksAdded);
        sleepInSecond(2);
        Assert.assertEquals(nameBooksAdd,nameBooksAdded);
        return this;
    }
    }
