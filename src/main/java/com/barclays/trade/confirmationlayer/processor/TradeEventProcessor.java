package com.barclays.trade.confirmationlayer.processor;

import com.barclays.trade.confirmationlayer.dao.ClientConfirmationDao;
import com.barclays.trade.confirmationlayer.entity.ClientConfirmation;
import com.barclays.trade.confirmationlayer.entity.ClientRules;
import com.barclays.trade.confirmationlayer.exception.ClientRuleException;
import com.barclays.trade.confirmationlayer.message.ConfirmationMessage;
import com.barclays.trade.confirmationlayer.message.Message;
import com.barclays.trade.confirmationlayer.model.TradeEvent;
import com.barclays.trade.confirmationlayer.service.ConfirmationService;
import com.barclays.trade.confirmationlayer.service.RuleEngineService;
import com.barclays.trade.confirmationlayer.utils.TradeEventValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

/**
 * Processor to process {@link com.barclays.trade.confirmationlayer.model.TradeEvent}
 */
@Component
public class TradeEventProcessor implements EventProcessor<TradeEvent> {

    private static final Logger LOGGER = LoggerFactory.getLogger(TradeEventProcessor.class);

    public static final int VALID_RULE_SIZE = 1;
    private final TradeEventValidator tradeEventValidator;
    private final RuleEngineService ruleEngineService;
    private final ClientConfirmationDao clientConfirmationDao;
    private final ConfirmationService confirmationService;


    public TradeEventProcessor(TradeEventValidator tradeEventValidator, RuleEngineService ruleEngineService, ClientConfirmationDao clientConfirmationDao, ConfirmationService confirmationService) {
        this.tradeEventValidator = tradeEventValidator;
        this.ruleEngineService = ruleEngineService;
        this.clientConfirmationDao = clientConfirmationDao;
        this.confirmationService = confirmationService;
    }

    public Message processTradeEvent(TradeEvent event){
        LOGGER.info("Processing Trade event {}", event);

        Message message = new ConfirmationMessage();
        tradeEventValidator.validate(event);
        List<ClientRules> clientRules = ruleEngineService.generateRulesForClient(event);
        validateRuleSize(clientRules);
        //Should get only one rule , if not it would have been an exception
        ClientRules finalizedRule= clientRules.get(0);
        List<ClientConfirmation> confirmationsToNotify = clientConfirmationDao.getClientConfirmationsByRuleId(finalizedRule.getId());
        message = confirmationService.processConfirmations(confirmationsToNotify);
        return message ;

    }

    private void validateRuleSize(List<ClientRules> clientRules) {
        if(Objects.isNull(clientRules) || clientRules.isEmpty()){
            throw new ClientRuleException("No rule exist for the event");
        } else if (clientRules.size()> VALID_RULE_SIZE) {
            throw new ClientRuleException("More than one rule exist for the client");
        }
    }

    @Override
    public void process(TradeEvent event) {

    }
}
