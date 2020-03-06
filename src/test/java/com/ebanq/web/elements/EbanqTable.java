package com.ebanq.web.elements;

import org.openqa.selenium.By;

public class EbanqTable extends ElementImpl implements Table {
    private static final String TABLE_ELEMENT_XPATH = "//*[@title = '%s']/ancestor::tr/td[@data-title='%s']";

    public EbanqTable(String keyCellText, String necessaryValue) {
        super(By.xpath(String.format(TABLE_ELEMENT_XPATH, keyCellText, necessaryValue)));
    }

    @Override
    public String get() {
        return getText();
    }
}