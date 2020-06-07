package com.bellang.model.enumType;

import java.util.HashMap;
import java.util.Map;

public enum FrontTemplate {

    TopLeft(0),
    TopRight(1),
    MiddleLeft(2),
    MiddleRight(3),
    BtmLeft(4),
    BtmRight(5);

    private int value;
    private static Map map = new HashMap<>();

    private FrontTemplate(int value) {
        this.value = value;
    }

    static {
        for (FrontTemplate pageType : FrontTemplate.values()) {
            map.put(pageType.value, pageType);
        }
    }

    public static FrontTemplate valueOf(int pageType) {
        return (FrontTemplate) map.get(pageType);
    }

    public int getValue() {
        return value;
    }
}


