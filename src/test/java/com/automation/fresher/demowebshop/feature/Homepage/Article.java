package com.automation.fresher.demowebshop.feature.Homepage;

import com.vmo.nopcommerce.common.BaseTest;
import com.vmo.nopcommerce.helper.Log;
import com.vmo.nopcommerce.pageobject.ArticlePageObject;
import com.vmo.nopcommerce.pageobject.HomePageObject;
import com.vmo.nopcommerce.pageobject.PageGenerator;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
@Epic("Nopcommerce")
@Feature("HomePageObject")
@Story("AddCommentSuccess")
public class Article extends BaseTest {
    HomePageObject homePage;
    ArticlePageObject articlePage;

    @BeforeMethod
    public void setUp() {
        homePage = PageGenerator.getHomePageObject(driver);
        articlePage = PageGenerator.getArticleObject(driver);
    }

    @Test
    public void TC05_Verify_Read_News_And_Leave_Comment() {
        homePage.openHomePage()
                .verifyTitleHomepage("nopCommerce demo store")
                .clickToANewArticle();
        Log.info("TC5_Step1");
        Log.allure("TC5_Step1");
        articlePage.verifyTitleArticle("nopCommerce demo store. nopCommerce new release!")
                .sendKeysToTitleTextBox("Tien test nha")
                .sendKeysToCommentTextBox("Một ngày thật đẹp nhó")
                .clickToNewCommentButton()
                .verifyMsgAddCommentSuccess("News comment is successfully added.");
        Log.info("TC5_Step2");
        Log.allure("TC5_Step2");

    }
}

