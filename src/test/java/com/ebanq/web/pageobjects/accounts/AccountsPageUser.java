package com.ebanq.web.pageobjects.accounts;

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
import static com.ebanq.web.other.Urls.ACCOUNTS_PAGE_USER;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AccountsPageUser extends BasePage {
    private final String ACTIVE_USER_ACCOUNTS_PAGE_CSS = "app-user-transactions > .main";
    private final String ACCOUNT_BALANCE_XPATH = "//*[contains(text(), 'Account number')]/parent::div/*[contains(@class, 'bottom-hint')]";
    private final String CURRENT_ACCOUNT_BALANCE_XPATH = "//*[contains(text(), 'Current balance')]/parent::div/*[contains(@class, 'other-text')]";

    @Override
    public AccountsPageUser isPageOpened() {
        $(ACTIVE_USER_ACCOUNTS_PAGE_CSS).shouldBe(Condition.visible);
        return this;
    }

    public AccountsPageUser openPage() {
        open(ACCOUNTS_PAGE_USER);
        return this;
    }

    public AccountsPageUser changeAccount(String accountNumber) {
        new EbanqAccountSelect("Account number")
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
        return $(By.xpath("//span[contains(text(), 'Account number')]/ancestor::div/span[@class='bottom-hint']")).getText().replaceAll("[^.\\-\\d]]", "");
    }

    public AccountsPageUser validateTransferDetails(String ID, String descriptionAccountNumber, String transferAmount) {
        HashMap<String, String> row = new HashMap<>();
        row = new EbanqTable(ID).getRow();
        String currentDescription = row.get("Description");
        String currentAmount = row.get("Debit/Credit");
        String currentStatus = row.get("Status");
        assertTrue(currentDescription.contains(descriptionAccountNumber));
        assertEquals(currentAmount, transferAmount);
        assertEquals(currentStatus, "Executed");
        return this;
    }
}