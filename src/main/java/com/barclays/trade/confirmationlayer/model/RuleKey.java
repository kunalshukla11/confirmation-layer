package com.barclays.trade.confirmationlayer.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Objects;

/**
 * Key used to uniquely identify rules
 */
@Data
@Builder
@AllArgsConstructor
public class RuleKey {
    private String tradeNameLocation;
    private String account;
    private BusinessLine businessLine;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RuleKey ruleKey = (RuleKey) o;
        return Objects.equals(tradeNameLocation, ruleKey.tradeNameLocation) && Objects.equals(account, ruleKey.account) && businessLine == ruleKey.businessLine;
    }

    @Override
    public int hashCode() {
        return Objects.hash(tradeNameLocation, account, businessLine);
    }

}
