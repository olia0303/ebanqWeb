package com.ebanq.web.tests;

import com.ebanq.web.model.Account;
import com.ebanq.web.model.AccountFactory;
import com.ebanq.web.tests.base.BaseTest;
import org.testng.annotations.Test;

public class AccountsTest extends BaseTest {
    @Test(description = "New account creation filling all the required fields")
    public void createNewAccountTest() {
        Account account = AccountFactory.getAccount("4", "Savings - EUR", "mjohnson", "Active", "100.00");
        loginSteps.logIn(testData.ADMIN_USER, testData.ADMIN_PASS);
        accountsSteps.openCreateNewAccountsPage()
                .createNewAccount(account)
                .accountDetailsInTableShouldBeCorrect(account);
    }
}