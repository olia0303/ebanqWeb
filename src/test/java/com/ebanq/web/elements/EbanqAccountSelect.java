package com.ebanq.web.elements;

import lombok.extern.log4j.Log4j;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;

@Log4j
public class EbanqAccountSelect extends ElementImpl implements Select {
    private final static String SELECT_ELEMENT_XPATH = "//span[contains(text(), '%s')]/ancestor::div/ng-select";
    private final static String SELECT_OPTION_XPATH = "//span[contains(text(), '%s')]";
    private String label;

    public EbanqAccountSelect(String label) {
        super(By.xpath(String.format(SELECT_ELEMENT_XPATH, label)));
        this.label = label;
    }

    @Override
    public void selectValue(String option) {
        if (StringUtils.isNotEmpty(option)) {
            log.info(String.format("Choosing option %s from %s with label '%s'", option, element.getTagName(), label));
            element.click();
            element.find(By.xpath(String.format(SELECT_OPTION_XPATH, option))).click();
        }
    }
}