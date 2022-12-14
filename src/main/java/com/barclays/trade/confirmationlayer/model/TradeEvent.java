package com.barclays.trade.confirmationlayer.model;

import lombok.*;

import java.math.BigDecimal;

/**
 * Class to represent trade event
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TradeEvent {

    private String tradeNameLocation;
    private String account;
    private BusinessLine businessLine;
    private BigDecimal amount;
    private String currency;
    private String legalEntity;


}
