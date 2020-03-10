package com.ebanq.web.pageobjects;

import com.codeborne.selenide.ex.ElementNotFound;
import com.ebanq.web.exception.ElementNotFoundException;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public abstract class BasePage {
    abstract protected BasePage isPageOpened();
    public static final String ACTIVE_PAGE_CSS = ".content";
    public static final String FIELD_XPATH = "//span[normalize-space(text())=\"%s\"]//following-sibling::span|//span[normalize-space(text())=\"%s\"]//following-sibling::a";

    public String getDisplayValue(String fieldTitle) {
        try {
            return $(By.xpath(String.format(FIELD_XPATH, fieldTitle, fieldTitle))).getText();
        } catch (ElementNotFound ex) {
            throw new ElementNotFoundException(String.format("Cannot find field by title: '%s'", fieldTitle), ex);
        }
    }
}