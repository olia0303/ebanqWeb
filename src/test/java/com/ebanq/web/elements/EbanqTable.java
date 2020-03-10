package com.ebanq.web.elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import utils.JavascriptUtilities;

import java.util.HashMap;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;



public class EbanqTable extends ElementImpl implements Table {
    private static final String TABLE_ELEMENT_XPATH = "//*[normalize-space(text())= '%s']/ancestor::tr";

    public EbanqTable(String keyCellText) {
        super(By.xpath(String.format(TABLE_ELEMENT_XPATH, keyCellText)));
    }

    @Override
    public String get(String necessaryValue) {
        return element.$(By.xpath(String.format(".//td[@data-title='%s']", necessaryValue))).getText();
    }

    /**The method collects all the information of a table row and composes it into pairs of values.
     * The first value is the column title of the table. And the second value is the desired value of this column.
     * To use the method, you must pass the text of the required cell, which will be the key.
     *
     * Example how you can get info from column "Owner:
     * HashMap<String, String> example;
     * example.get("Owner");
     *
     * @return - HashMap<String, String>
     */
    @Override
    public HashMap<String, String> getRow() {
        int columnsQty = $$(By.xpath("//tr/th")).size();
        HashMap<String, String> cell = new HashMap<String, String>();
        int isInvisibleColumnExist = 0;
        for(int j = 1; j <= columnsQty; j++) {
            int i = j;                                                                  //  it's necessary when columns Qty in thead are not equels columns Qty in tbody
                if(!element.$(By.xpath(".//td[" + j + "]")).is(Condition.visible)) {
                    isInvisibleColumnExist++;
                }
            String cellHeaderText = $(By.xpath("//tr/th[" + j + "]")).getText();
            i += isInvisibleColumnExist;
            String cellText = element.$(By.xpath(".//td[" + i + "]")).getText();
            cell.put(cellHeaderText, cellText);
        }
        return cell;
    }
    
    public String openLinkFromRowByText(String columnName, String rowText) {
        SelenideElement el;
                el= $(By.xpath(String.format("//table//th[@name='%s']/ancestor::table//td[contains(text(),\"%s\")]", columnName, rowText)));
        new JavascriptUtilities().scrollToElement(getWebDriver(), el);
        new JavascriptUtilities().clickJs(getWebDriver(), el);
        return rowText;
    }
}