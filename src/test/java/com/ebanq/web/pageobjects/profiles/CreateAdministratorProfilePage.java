package com.ebanq.web.pageobjects.profiles;

import com.codeborne.selenide.Condition;
import com.ebanq.web.elements.EbanqInput;
import com.ebanq.web.elements.EbanqSelect;
import com.ebanq.web.model.Administrator;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class CreateAdministratorProfilePage extends BaseProfilesPage {
    @Override
    public CreateAdministratorProfilePage isPageOpened() {
        $(PAGE_HEADER_CSS)
                .waitUntil(Condition.visible, 30000)
                .shouldHave(Condition.text("Create New Profile"));
        return this;
    }

    public CreateAdministratorProfilePage fillInRequiredFields(Administrator administrator) {
        log.info("Creation of New Administrator" + administrator);
        new EbanqInput("Username")
                .write(administrator.getUserName());
        new EbanqInput("First Name")
                .write(administrator.getFirstName());
        new EbanqInput("Last Name")
                .write(administrator.getLastName());
        new EbanqInput("E-mail Address")
                .write(administrator.getEmail());
        new EbanqInput("Confirm E-mail address")
                .write(administrator.getEmail());
        new EbanqInput("Password")
                .write(administrator.getPassword());
        new EbanqInput("Confirm Password")
                .write(administrator.getPassword());
        new EbanqSelect("Status")
                .selectValue(administrator.getStatus());
        new EbanqSelect("Class")
                .selectValue(administrator.getAdminClass());
        return this;
    }
}
