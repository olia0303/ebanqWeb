package com.ebanq.web.pageobjects;

import com.ebanq.web.elements.EbanqTable;
import org.apache.commons.lang3.StringUtils;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public abstract class BaseDetailsPage extends BasePage {
   
    protected void validateFieldValue(String fieldName, String value) {
        if (StringUtils.isNotEmpty(value)) {
            assertThat(String.format("Value of '%s' should be correct", fieldName),
                    getDisplayValue(fieldName),
                    is(value));
        }
    }
    
    protected void validateFieldValue(String fieldName, double value) {
        assertThat(String.format("Value of '%s' should be correct", fieldName),
                getDisplayValue(fieldName),
                is(String.valueOf((int)value)));
    }
    
    public BaseDetailsPage openDetailsPage(String columnName, String value) {
        EbanqTable table = new EbanqTable(columnName);
        table.openLinkFromRowByText(columnName, value);
        return this;
    }
}
