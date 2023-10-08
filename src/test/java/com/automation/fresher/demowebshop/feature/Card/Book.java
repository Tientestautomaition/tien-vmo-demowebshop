package com.automation.fresher.demowebshop.feature.Card;

import com.vmo.demowebshop.common.BaseTest;
import com.vmo.demowebshop.pageobject.BookPageObject;
import com.vmo.demowebshop.pageobject.PageGenerator;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Epic("demoWebShop")
@Feature("AddToCart")
@Story("AddBooksToCartSuccessfully")
public class Book extends BaseTest {
    BookPageObject bookPage;

    @BeforeMethod
    public void setUp() {
        bookPage = PageGenerator.getBookObject(driver);
    }
    @Test()
    public void TC_02_Verify_Login_To_Demo_Web_Shop() {
        bookPage.openHomepage("https://demowebshop.tricentis.com/")
                .verifyTitleHomePage("Demo Web Shop")
                .clickToBookTag()
                .verifyTitleBookPage("Demo Web Shop. Books")
                .clickOnBooksAddToCart()
                .verifyAppearMsgAddProductToCartSuccess()
                .hoverOnShoppingCartTag()
                .verifyProductAreAdded();

    }


}

