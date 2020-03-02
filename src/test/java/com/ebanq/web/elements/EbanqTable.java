package com.ebanq.web.elements;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class EbanqTable extends ElementImpl implements Table {
    public EbanqTable() {
        super(By.xpath("//table"));
    }

    @Override
    public String getRowInfoByCellText(String keyCellText, String necessaryValue) {
            String value = $(String.format("[title='%s']", keyCellText)).parent().$(String.format("[data-title='%s']", necessaryValue)).shouldBe(Condition.visible).getText();
        return value;
    }
}