package com.ebanq.web.pageobjects.reports;

import com.codeborne.selenide.Condition;
import com.ebanq.web.elements.EbanqAccountSelect;
import com.ebanq.web.elements.EbanqTable;
import com.ebanq.web.pageobjects.BasePage;
import java.util.HashMap;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.ebanq.web.other.Urls.REPORTS_PAGE;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ReportsPageUser extends BasePage {
    private final String ACTIVE_REPORTS_PAGE_USER_CSS = "app-specific-account-statement > .container";

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
        return this;
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