package com.automation.fresher.demowebshop.feature.Card;

import com.vmo.demowebshop.common.BaseTest;
import com.vmo.demowebshop.pageobject.BuyItemPageObject;
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
public class BuyItemSuccessfully extends BaseTest {
    BuyItemPageObject BuyItemPage;

    @BeforeMethod
    public void setUp() {
        BuyItemPage = PageGenerator.getBuyItemPageObject(driver);
    }
    @Test()
    public void TC_04_Verify_Buy_Item_Successfully() {
        BuyItemPage.openHomepage("https://demowebshop.tricentis.com/")
                .verifyTitleHomePage("Demo Web Shop")
                .clickOnDigitalDownloadTag()
                .verifyUserInDigitalDownloadPage("Demo Web Shop. Digital downloads")
                .clickAddProductToCartAndVerifyAppearMsgAndVerifyQuantityIncreasesSuccess()
                .clickOnShoppingCartTag()
                .verifyUserInCartPage("Demo Web Shop. Shopping Cart")
                .clickOnCheckboxTermOfService()
                .verifyCheckboxTermOfServiceSelected()
                .clickOnCheckOutButton()
                .verifyUserInCheckOutPage("https://demowebshop.tricentis.com/login/checkoutasguest?returnUrl=%2Fcart")
                .clickOnCheckOuAsGuessButton();
}}




