package com.ebanq.web.pageobjects.accounts;

import com.codeborne.selenide.Condition;
import com.ebanq.web.elements.EbanqTable;
import com.ebanq.web.model.Account;
import com.ebanq.web.pageobjects.BasePage;
import static com.codeborne.selenide.Selenide.*;
import static com.ebanq.web.other.Urls.ACCOUNTS_PAGE;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AccountsPage extends BasePage {
    public static final String CREATE_BTN_CSS = "[routerlink='/admin/accounts/accounts/create']";
    public static final String ACTIVE_ACCOUNTS_PAGE_CSS = "app-accounts-list > .container";

    @Override
    public AccountsPage isPageOpened() {
        $(ACTIVE_ACCOUNTS_PAGE_CSS).shouldBe(Condition.visible);
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
        String currentOwner = new EbanqTable().getRowInfoByCellText(account.getAccountNumber(), "Owner");
        String currentType = new EbanqTable().getRowInfoByCellText(account.getAccountNumber(), "Type");
        String currentCurrency = new EbanqTable().getRowInfoByCellText(account.getAccountNumber(), "Currency");
        String currentStatus = new EbanqTable().getRowInfoByCellText(account.getAccountNumber(), "Status");
        String currentBalance = new EbanqTable().getRowInfoByCellText(account.getAccountNumber(), "Balance");
        assertEquals(currentOwner, account.getUser());
        assertTrue(account.getAccountType().contains(currentType));
        assertTrue(account.getAccountType().contains(currentCurrency));
        assertEquals(currentBalance, account.getInitialBalance());
        assertEquals(currentStatus, account.getStatus());
        return this;
    }
}