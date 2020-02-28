package com.ebanq.web.elements;

import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;

@Log4j2
public class EbanqInput extends ElementImpl implements Input{
    private static final String INPUT_ELEMENT_XPATH = "%s//label[normalize-space(text()) = '%s']/..//input";
    private String label;
    
    public EbanqInput(String label) {
        super(By.xpath(String.format(INPUT_ELEMENT_XPATH, "", label)));
        this.label = label;
    }
    
    @Override
    public void write(String text) {
        if(StringUtils.isNotEmpty(text)) {
            log.debug(String.format("Writing text %s into %s with label '%s'", text, element.getTagName(), label));
            clear();
            sendKeys(text);
        }
    }

    public void write(double value) {
        String text = String.valueOf(value);
        write(text);
    }
}


