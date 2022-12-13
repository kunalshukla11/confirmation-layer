package com.barclays.trade.confirmationlayer.processor;

import com.barclays.trade.confirmationlayer.model.TradeEvent;
import org.springframework.stereotype.Service;

/**
 * Processor to process {@link com.barclays.trade.confirmationlayer.model.TradeEvent}
 */
@Service
public class TradeEventProcessor implements EventProcessor<TradeEvent> {


    @Override
    public void process(TradeEvent event) {

    }
}
