package com.ebanq.web.pageobjects.reports;

import com.codeborne.selenide.Condition;
import com.ebanq.web.elements.EbanqAccountSelect;
import com.ebanq.web.elements.EbanqTable;
import com.ebanq.web.pageobjects.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.HashMap;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.ebanq.web.other.Urls.REPORTS_PAGE;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ReportsPageUser extends BasePage {
    private final String ACTIVE_REPORTS_PAGE_USER_CSS = "app-specific-account-statement > .container";
    private final String ACCOUNT_BALANCE_XPATH = "//*[contains(text(), 'Account')]/parent::div/*[contains(@class, 'bottom-hint')]";
    private final String CURRENT_ACCOUNT_BALANCE_XPATH = "//*[contains(text(), 'Current balance')]/parent::div/*[contains(@class, 'inform-text')]";

    @Override
    public ReportsPageUser isPageOpened() {
        $(ACTIVE_REPORTS_PAGE_USER_CSS).shouldBe(Condition.visible);
        return this;
    }

    public ReportsPageUser openPage() {
        open(REPORTS_PAGE);
        return this;
    }

    public ReportsPageUser changeAccount(String accountNumber) {
        new EbanqAccountSelect("Account")
                .selectValue(accountNumber);
        (new WebDriverWait(getWebDriver(), 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                String accountBalance = $(By.xpath(ACCOUNT_BALANCE_XPATH)).getText();
                String currentAccountBalance = $(By.xpath(CURRENT_ACCOUNT_BALANCE_XPATH)).getText();
                return accountBalance.contains(".") && currentAccountBalance.contains(accountBalance);
            }
        });
        return this;
    }

    public String getAccountBalance() {
        return $(By.xpath(ACCOUNT_BALANCE_XPATH)).getText().replaceAll("[^.\\-\\d]", "");
    }

    public ReportsPageUser validateTransferDetails(String ID, String descriptionAccountNumber, String transferAmount) {
        HashMap<String, String> row = new HashMap<>();
        row = new EbanqTable(ID).getRow();
        String currentDescription = row.get("Description");
        String currentAmount = row.get("Debit/Credit");
        assertTrue(currentDescription.contains(descriptionAccountNumber));
        assertEquals(currentAmount, transferAmount);
        return this;
    }
}