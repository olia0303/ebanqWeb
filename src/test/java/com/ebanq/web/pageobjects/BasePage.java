package com.ebanq.web.pageobjects;

public abstract class BasePage {
    abstract protected BasePage isPageOpened();
    public static final String ACTIVE_PAGE_CSS = ".content";
}