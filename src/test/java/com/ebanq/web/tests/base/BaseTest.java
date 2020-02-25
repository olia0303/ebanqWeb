package com.ebanq.web.tests.base;

import com.ebanq.web.steps.LoginSteps;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Log4j2
@Listeners(TestListener.class)
public class BaseTest {
    public LoginSteps loginSteps;

    @BeforeMethod(description = "Opening browser")
    public void startBrowser() {
        loginSteps = new LoginSteps();
    }

    @AfterMethod(description = "Closing browser", alwaysRun = true)
    public void stopBrowser() {
        log.info("Closing browser after method");
        loginSteps.closeBrowser();
    }
}
