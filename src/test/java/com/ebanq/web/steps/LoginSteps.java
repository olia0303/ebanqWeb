package com.ebanq.web.steps;

import com.codeborne.selenide.Configuration;
import com.ebanq.web.pageobjects.HomePage;
import com.ebanq.web.pageobjects.LoginPage;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utils.driver.CapabilitiesGenerator;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;

@Log4j2
public class LoginSteps {
    private LoginPage loginPage;
    private HomePage homePage;
    private WebDriver driver;

    public LoginSteps(){
        loginPage = new LoginPage();
        homePage = new HomePage();
    }

    public void startBrowser() {
        ChromeOptions options = CapabilitiesGenerator.getChromeOptions();
        driver = new ChromeDriver(options);
        Configuration.timeout = 30000;
        setWebDriver(driver);
        getWebDriver().manage().window().maximize();
    }

    @Step("Login into the system using credentials: {username}, {password}")
    public void login(String username, String password){
        startBrowser();
        loginPage
                .openPage()
                .login(username, password);
        homePage.isPageOpened();
    }

    @Step("Log out from system")
    public void logOut(){
        loginPage.logOut();
        loginPage.isPageOpened();
        closeBrowser();
    }

    public void closeBrowser() {
        log.debug("Closing Chrome instance " + driver);
        if (null != driver) {
            driver.quit();
        }
    }
}
