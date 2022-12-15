package com.barclays.trade.confirmationlayer.controller;

import com.barclays.trade.confirmationlayer.message.Message;
import com.barclays.trade.confirmationlayer.model.TradeEvent;
import com.barclays.trade.confirmationlayer.processor.TradeEventProcessor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller class to handle Trade events
 */
@RestController
@RequestMapping("/event")
public class TradeEventController {

    private final TradeEventProcessor tradeEventProcessor;

    public TradeEventController(TradeEventProcessor tradeEventProcessor) {
        this.tradeEventProcessor = tradeEventProcessor;
    }

    @PostMapping("/process")
    public ResponseEntity<Message> processTradeEvent(@RequestBody TradeEvent tradeEvent) {
        Message body = tradeEventProcessor.processTradeEvent(tradeEvent);
        return ResponseEntity.ok(body);
    }
}
