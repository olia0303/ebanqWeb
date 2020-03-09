package com.ebanq.web.elements;

import org.openqa.selenium.By;

public class EbanqText extends ElementImpl implements Text {
    private final static String TEXT_ELEMENT_XPATH = "//*[contains(text(), '%s')]/parent::div";
    private String label;

    public EbanqText(String label) {
        super(By.xpath(String.format(TEXT_ELEMENT_XPATH, label)));
        this.label = label;
    }

    @Override
    public String get() {
        return element.getText().replaceAll(".+\n", "");
    }
}