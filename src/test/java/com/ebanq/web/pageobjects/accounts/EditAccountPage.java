package com.ebanq.web.pageobjects.accounts;

import com.codeborne.selenide.Condition;
import com.ebanq.web.model.Account;
import com.ebanq.web.pageobjects.BasePage;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class EditAccountPage extends BasePage {
    public static final String ACTIVE_EDIT_ACCOUNT_PAGE_CSS = "app-view-account > .container";

    @Override
    public EditAccountPage isPageOpened() {
        $(ACTIVE_EDIT_ACCOUNT_PAGE_CSS).shouldBe(Condition.visible);
        return this;
    }

    public EditAccountPage validateAccountDetails(Account account) {
        String currentUsername = getCurrentInfo("Username");
        String currentAccountType = getCurrentInfo("Account Type");
        String currentStatus = getCurrentInfo("Status");
        String currentInitialBalance = getCurrentInfo("Initial Balance");
        assertEquals(currentUsername, account.getUser());
        assertTrue(account.getAccountType().contains(currentAccountType));
        assertEquals(currentInitialBalance, account.getInitialBalance());
        assertEquals(currentStatus, account.getStatus());
        return this;
    }

    private String getCurrentInfo(String text) {
        String value = $(By.xpath(String.format("//*[contains(text(), '%s')]/ancestor::div/*[contains(@class, 'clip')]", text))).getText();
        return value;
    }
}