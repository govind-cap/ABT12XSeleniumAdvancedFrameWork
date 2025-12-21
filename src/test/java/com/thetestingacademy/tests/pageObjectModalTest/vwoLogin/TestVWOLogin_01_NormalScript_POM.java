package com.thetestingacademy.tests.pageObjectModalTest.vwoLogin;


import com.thetestingacademy.pages.pageObjectModal.vwoLogin.normalPOM.DashBoardPage;
import com.thetestingacademy.pages.pageObjectModal.vwoLogin.normalPOM.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestVWOLogin_01_NormalScript_POM {

    @Owner("Govind")
    @Description("Verify that with invalid email, pass, error message is shown on the app.vwo.com")
    @Test
    public void test_negative_vwo_login() {
        // Driver Manager Code - 1
        WebDriver driver = new ChromeDriver();


        // Page Class Code (POM Code) - 2
        LoginPage loginPage = new LoginPage(driver);
        String error_msg = loginPage.loginToVWOLoginInvalidCreds("admin@gmail.com","1234");

        // Assertions - 3
        assertThat(error_msg).isNotNull().isNotBlank().isNotEmpty();
        Assert.assertEquals(error_msg,"Your email, password, IP address or location did not match");

        driver.quit();


    }

    @Owner("Govind")
    @Description("TC#2-Verify that valid creds dashboard page is loaded")
    @Test
    public void testLoginPositiveVWO() {

        // Driver Manager Code - 1
        WebDriver driver = new ChromeDriver();
        LoginPage loginPage_VWO = new LoginPage(driver);
        loginPage_VWO.loginToVWOLoginValidCreds("jemafoy850@roratu.com","Test@1234");

        DashBoardPage dashBoardPage  = new DashBoardPage(driver);
        String usernameLoggedIn = dashBoardPage.loggedInUserName();


        assertThat(usernameLoggedIn).isNotBlank().isNotNull().isNotEmpty();
        Assert.assertEquals(usernameLoggedIn,"Roratu");


        driver.quit();

    }




    }
