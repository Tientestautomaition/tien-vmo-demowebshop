package com.automation.fresher.demowebshop.feature.Card;

import com.vmo.demowebshop.common.BaseTest;
import com.vmo.demowebshop.pageobject.BookPageObject;
import com.vmo.demowebshop.pageobject.CartPageObject;
import com.vmo.demowebshop.pageobject.PageGenerator;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Epic("demoWebShop")
@Feature("RemoveProductFromCart")
@Story("ARemoveProductFromCartSuccessfully")
public class RemoveProductFromCart extends BaseTest {
    CartPageObject cartPage;

    @BeforeMethod
    public void setUp() {
        cartPage = PageGenerator.getCartPageObject(driver);
    }
    @Test()
    public void TC_02_Verify_Login_To_Demo_Web_Shop() {
        cartPage.openHomepage("https://demowebshop.tricentis.com/")
                .verifyTitleHomePage("Demo Web Shop");

}}



