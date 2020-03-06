package com.ebanq.web.pageobjects.accounts;

import com.codeborne.selenide.Condition;
import com.ebanq.web.elements.EbanqTable;
import com.ebanq.web.model.Account;
import com.ebanq.web.pageobjects.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import static com.codeborne.selenide.Selenide.*;
import static com.ebanq.web.other.Urls.ACCOUNTS_PAGE;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class AccountsPage extends BasePage {
    public static final String CREATE_BTN_CSS = "[routerlink='/admin/accounts/accounts/create']";
    public static final String ACTIVE_ACCOUNTS_PAGE_CSS = "[data-title='Balance'] > span";

    @Override
    public AccountsPage isPageOpened() {
        $(ACTIVE_ACCOUNTS_PAGE_CSS).shouldBe(Condition.visible).shouldNot(Condition.empty);
        return this;
    }

    public AccountsPage openPage() {
        open(ACCOUNTS_PAGE);
        return this;
    }

    public void clickCreateNewAccount() {
        $(CREATE_BTN_CSS).click();
    }

    public AccountsPage isAccountVisibleOnGrid(Account account) {
        isPageOpened();
        String currentOwner = new EbanqTable(account.getAccountNumber(), "Owner").get();
        String currentType = new EbanqTable(account.getAccountNumber(), "Type").get();
        String currentCurrency = new EbanqTable(account.getAccountNumber(), "Currency").get();
        String currentStatus = new EbanqTable(account.getAccountNumber(), "Status").get();
        String currentBalance = new EbanqTable(account.getAccountNumber(), "Balance").get();
        assertEquals(currentOwner, account.getUser());
        assertTrue(account.getAccountType().contains(currentType));
        assertTrue(account.getAccountType().contains(currentCurrency));
        assertEquals(currentBalance, account.getInitialBalance());
        assertEquals(currentStatus, account.getStatus());
        return this;
    }

    public AccountsPage openEditAccountPage(Account account) {
        WebElement element = $(String.format("[title='%s']", account.getAccountNumber()));
        //There is need use js here because *element* is overlapped by popup
        JavascriptExecutor executor = (JavascriptExecutor)getWebDriver();
        executor.executeScript("arguments[0].click();", element);
        return this;
    }
}