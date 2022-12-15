package com.barclays.trade.confirmationlayer.processor;

import com.barclays.trade.confirmationlayer.message.ConfirmationMessage;
import com.barclays.trade.confirmationlayer.message.Message;
import com.barclays.trade.confirmationlayer.model.TradeEvent;
import com.barclays.trade.confirmationlayer.utils.TradeEventValidator;
import org.springframework.stereotype.Component;

/**
 * Processor to process {@link com.barclays.trade.confirmationlayer.model.TradeEvent}
 */
@Component
public class TradeEventProcessor implements EventProcessor<TradeEvent> {

    private final TradeEventValidator tradeEventValidator;

    public TradeEventProcessor(TradeEventValidator tradeEventValidator) {
        this.tradeEventValidator = tradeEventValidator;
    }

    public Message processTradeEvent(TradeEvent event){
        Message message = new ConfirmationMessage();
        tradeEventValidator.validate(event);


        return message ;

    }
    @Override
    public void process(TradeEvent event) {

    }
}
