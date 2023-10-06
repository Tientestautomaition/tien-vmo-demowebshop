package com.vmo.nopcommerce.pageobject;

import com.vmo.nopcommerce.common.BasePage;
import com.vmo.nopcommerce.interfaces.ArticlePageUI;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ArticlePageObject extends BasePage {

    public ArticlePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public ArticlePageObject verifyTitleArticle(String expectedTitle) {
        Assert.assertEquals(driver.getTitle(), expectedTitle);
        return this;
    }

    public ArticlePageObject sendKeysToTitleTextBox(String textValue) {
        sendKeyToElement(driver, ArticlePageUI.TITLE_TXT, textValue);
        return this;
    }

    public ArticlePageObject sendKeysToCommentTextBox(String textValue) {
        sendKeyToElement(driver, ArticlePageUI.COMMENT_TXT, textValue);
        return this;
    }

    public ArticlePageObject clickToNewCommentButton() {
        clickToElement(driver, ArticlePageUI.NEW_COMMENT_BUTTON);
        return this;
    }

    public ArticlePageObject verifyMsgAddCommentSuccess(String expectedTitle) {
        Assert.assertEquals(getTextElement(driver, ArticlePageUI.MSG_ADD_COMMENT_SUCCESS), expectedTitle);
        return this;
    }
}