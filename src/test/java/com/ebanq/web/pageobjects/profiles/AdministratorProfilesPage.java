package com.ebanq.web.pageobjects.profiles;

import com.codeborne.selenide.Condition;
import com.ebanq.web.model.Administrator;
import com.ebanq.web.pageobjects.BaseDetailsPage;

import static com.codeborne.selenide.Selenide.$;

public class AdministratorProfilesPage extends BaseDetailsPage {
    public static final String PAGE_CSS = ".information-fields";

    @Override
    public AdministratorProfilesPage isPageOpened() {
        $(PAGE_CSS)
                .waitUntil(Condition.visible, 30000);
        return this;
    }

    public AdministratorProfilesPage validateDetails(Administrator administrator) {
        validateFieldValue("Username", administrator.getUserName());
        validateFieldValue("Full Name", administrator.getFirstName() + " " + administrator.getLastName());
        validateFieldValue("E-mail Address", administrator.getEmail());
        validateFieldValue("Class", administrator.getAdminClass());
        validateFieldValue("Status", administrator.getStatus());
        return this;
    }
}
