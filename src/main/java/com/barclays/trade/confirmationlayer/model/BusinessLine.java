package com.barclays.trade.confirmationlayer.model;

/**
 * Class to represent Business lines
 */
public enum BusinessLine {


    EQUITY("Equities"),
    FID("Fid"),
    DERIVS("Derivatives"),
    FX("Foreign Exchange"),
    STOCK_LONE("Stock Lone"),
    PWM("PWM"),
    ALL("All business lines");


    private String value;


    BusinessLine(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }


    public static BusinessLine getBusinessLine(String value) {
        for (BusinessLine businessLine : BusinessLine.values()) {
            if (businessLine.getValue().equals(value)) {
                return businessLine;
            }
        }
        return ALL;
    }




    }
