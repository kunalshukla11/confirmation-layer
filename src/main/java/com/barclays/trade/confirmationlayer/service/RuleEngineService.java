package com.barclays.trade.confirmationlayer.service;

import com.barclays.trade.confirmationlayer.dao.ClientDetailsDao;
import com.barclays.trade.confirmationlayer.entity.ClientDetails;
import com.barclays.trade.confirmationlayer.entity.ClientRules;
import com.barclays.trade.confirmationlayer.exception.NoDataException;
import com.barclays.trade.confirmationlayer.model.RuleKey;
import com.barclays.trade.confirmationlayer.model.TradeEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 Rule Engine class to provide all rules for clients
 */
@Service
public class RuleEngineService {
    private static final Logger LOGGER = LoggerFactory.getLogger(RuleEngineService.class);

    private final ClientDetailsDao clientDetailsDao;
    private final RuleKeyService ruleKeyService;

    public RuleEngineService(ClientDetailsDao clientDetailsDao, RuleKeyService ruleKeyService) {
        this.clientDetailsDao = clientDetailsDao;
        this.ruleKeyService = ruleKeyService;
    }

    public List<ClientRules> generateRulesForClient(TradeEvent tradeEvent) {
        LOGGER.error("Generating client for trade event {}", tradeEvent);
        List<ClientRules> generatedClientRules = new ArrayList<>();
        ClientDetails clientDetails = clientDetailsDao.findByClientName(tradeEvent.getTradeNameLocation());
        if (null == clientDetails) {
            LOGGER.error("Could not find client details for trade event {}", tradeEvent);
            throw new NoDataException("Could not find client details");
        }
        if (Objects.nonNull((clientDetails.getClientRules())) && !clientDetails.getClientRules().isEmpty()) {
            RuleKey eventRuleKey = ruleKeyService.getRuleKeyForTradeEvent(tradeEvent, clientDetails.getClientRules());
            List<ClientRules> sortedRulesByPriority = clientDetails.getClientRules().stream().sorted().collect(Collectors.toList());
            for (ClientRules clientRules : sortedRulesByPriority) {
                RuleKey databaseRuleKey = RuleKey.builder()
                        .account(clientRules.getAccount())
                        .tradeNameLocation(clientRules.getClientName())
                        .businessLine(clientRules.getBusinessLine())
                        .build();
                if (eventRuleKey.equals(databaseRuleKey)) {
                    generatedClientRules.add(clientRules);
                }
            }
        }

        return generatedClientRules;
    }
}
