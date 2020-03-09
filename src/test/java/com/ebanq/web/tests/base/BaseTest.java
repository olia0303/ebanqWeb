package com.ebanq.web.tests.base;

import com.ebanq.web.other.TestData;
import com.ebanq.web.pageobjects.accounts.AccountsPage;
import com.ebanq.web.pageobjects.accounts.CardsPage;
import com.ebanq.web.pageobjects.requests.RequestPage;
import com.ebanq.web.pageobjects.requests.TransferRequestDetailsPage;
import com.ebanq.web.steps.*;
import com.ebanq.web.steps.accounts.AccountsSteps;
import com.ebanq.web.steps.accounts.AccountsStepsUser;
import com.ebanq.web.steps.cards.CardsSteps;
import com.ebanq.web.steps.reports.ReportsUserSteps;
import com.ebanq.web.steps.requests.RequestsSteps;
import com.ebanq.web.steps.transfers.TransferUserSteps;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Log4j2
@Listeners(TestListener.class)
public class BaseTest {
    public LoginSteps loginSteps;
    public AccountsSteps accountsSteps;
    public TestData testData;
    public CardsSteps cardsSteps;
    public TransferUserSteps transferUserSteps;
    public RequestsSteps requestsSteps;
    public AccountsStepsUser accountsStepsUser;
    public ReportsUserSteps reportsUserSteps;

    @BeforeMethod(description = "Opening browser")
    public void startBrowser() {
        loginSteps = new LoginSteps();
        accountsSteps = new AccountsSteps();
        testData = new TestData();
        cardsSteps = new CardsSteps();
        transferUserSteps = new TransferUserSteps();
        requestsSteps = new RequestsSteps();
        accountsStepsUser = new AccountsStepsUser();
        reportsUserSteps = new ReportsUserSteps();
    }

    @AfterMethod(description = "Closing browser", alwaysRun = true)
    public void stopBrowser() {
        log.info("Closing browser after method");
        loginSteps.closeBrowser();
    }
}