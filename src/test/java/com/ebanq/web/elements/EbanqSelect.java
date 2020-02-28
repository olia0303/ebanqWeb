package com.ebanq.web.elements;

import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;

@Log4j2
public class EbanqSelect extends ElementImpl implements Select {

    private final static String SELECT_ELEMENT_XPATH = "%s//label[normalize-space(text()) = \"%s\"]/../..//ng-select/div";
    private final static String SELECT_OPTION_XPATH = "//div[contains(@class,'ng-option')]//span[contains(text(),'%s')]";
    
    private String label;
    
    public EbanqSelect(String label) {
        super(By.xpath(String.format(SELECT_ELEMENT_XPATH, "", label)));
        this.label = label;
    }

    public EbanqSelect(String parent, String label) {
        super(By.xpath(String.format(SELECT_ELEMENT_XPATH, label, "", label)));
        this.label = label;
    }
    
    public void selectValue(double value) {
        selectValue(String.valueOf(value));
    }

    public void selectValue(int value) {
        selectValue(String.valueOf(value));
    }
    
    @Override
    public void selectValue(String option) {
        if (StringUtils.isNotEmpty(option)) {
            element.click();
            element.find(By.xpath(String.format(SELECT_OPTION_XPATH, option))).click();
        }
    }
}
