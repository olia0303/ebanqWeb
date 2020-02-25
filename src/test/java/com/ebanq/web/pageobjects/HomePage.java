package com.ebanq.web.pageobjects;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$;

public class HomePage extends BasePage {
    @Override
    public HomePage isPageOpened() {
            $(".main-bar").shouldBe(Condition.visible);
            return this;
    }
}
