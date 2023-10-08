package com.automation.fresher.demowebshop.feature.Login;

import com.vmo.demowebshop.pageobject.LoginPageObject;
import com.vmo.demowebshop.pageobject.PageGenerator;
import com.vmo.demowebshop.common.BaseTest;
import com.vmo.demowebshop.utils.excelutils.ExcelReader;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Epic("demoWebShop")
@Feature("LoginPageObject")
@Story("LoginWithDataProvider")
public class LoginDemoWebShop extends BaseTest {

  static ExcelReader excelReader = new ExcelReader("src/test/resources/Testdata.xlsx", "data");
  LoginPageObject loginPage;

  @BeforeMethod
  public void setUp() {
    loginPage = PageGenerator.getLoginObject(driver);
  }

  @Test(dataProvider = "data")
  public void TC_01_Verify_Login_To_Demo_Web_Shop( String username, String password, String expectedMsg) {
loginPage.OpenHomepage("https://demowebshop.tricentis.com/")
        .verifyTitleHomePage("Demo Web Shop")
        .clickToLoginTag()
        .verifyTitleLoginPage("Demo Web Shop. Login")
        .sendKeysToUserNameTextBox(username)
        .sendKeysToPasswordTextBox(password)
        .clickToLoginButton()
        .verifyExpectedMsg(expectedMsg);
  }

  @DataProvider(name = "data")
  public static Object[][] getData() {
    return excelReader.getData(1, 3);
  }
}