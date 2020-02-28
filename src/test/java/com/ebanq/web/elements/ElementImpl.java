package com.ebanq.web.elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.*;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;

public class ElementImpl implements Element, WrapsElement {

    protected final SelenideElement element;

    protected ElementImpl(By xPath) {
        element = $(xPath).shouldBe(Condition.visible);
    }

    @Override
    public void click() {
        element.click();
    }

    @Override
    public void submit() {
        element.submit();
    }

    @Override
    public void sendKeys(CharSequence... charSequences) {
        element.sendKeys(charSequences);
    }

    @Override
    public void clear() {
        element.clear();
    }

    @Override
    public String getTagName() {
        return element.getTagName();
    }

    @Override
    public String getAttribute(String s) {
        return element.getAttribute(s);
    }

    @Override
    public boolean isSelected() {
        return element.isSelected();
    }

    @Override
    public boolean isEnabled() {
        return element.isEnabled();
    }

    @Override
    public String getText() {
        return element.getText();
    }

    public String getValue() {
        return element.getValue();
    }

    //TODO empty method
    @Override
    public List<WebElement> findElements(By by) {
        return null;
    }

    //TODO empty method
    @Override
    public WebElement findElement(By by) {
        return null;
    }

    @Override
    public boolean isDisplayed() {
        return element.isDisplayed();
    }

    //TODO empty method
    @Override
    public Point getLocation() {
        return null;
    }

    //TODO empty method
    @Override
    public Dimension getSize() {
        return null;
    }

    //TODO empty method
    @Override
    public Rectangle getRect() {
        return null;
    }

    @Override
    public String getCssValue(String s) {
        return element.getCssValue(s);
    }

    //TODO empty method
    @Override
    public <X> X getScreenshotAs(OutputType<X> outputType) throws WebDriverException {
        return null;
    }

    @Override
    public SelenideElement getWrappedElement() {
        return element;
    }
}