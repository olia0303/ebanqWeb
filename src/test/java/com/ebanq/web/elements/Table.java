package com.ebanq.web.elements;

import java.util.HashMap;

public interface Table {
    String get(String necessaryValue);
    HashMap<String, String> getRow();
}