package com.barclays.trade.confirmationlayer.utils;

import com.barclays.trade.confirmationlayer.exception.MessageValidationException;
import com.barclays.trade.confirmationlayer.model.TradeEvent;

import java.util.Objects;

public class TradeEventValidator implements Validator<TradeEvent> {
    @Override
    public void validate(TradeEvent tradeEvent) {
        validateField(tradeEvent.getTradeNameLocation(), "Trade name location");
        validateField(tradeEvent.getBusinessLine(), "Business Line");
        validateField(tradeEvent.getAccount(), "Account");
    }

    private void validateField(Object object, String field) {
        if(Objects.isNull(object)){
            throw new MessageValidationException("Required field"+ field + "is null");
        }
    }
}
