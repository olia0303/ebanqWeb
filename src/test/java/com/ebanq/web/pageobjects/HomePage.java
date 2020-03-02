package com.ebanq.web.pageobjects;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class HomePage extends BasePage {
    @Override
    public HomePage isPageOpened() {
            $(".main-bar").shouldBe(Condition.visible);
            return this;
    }

    public void logOut() {
        $(By.xpath("//span[contains(text(),'Log Out')]")).click();
    }
}