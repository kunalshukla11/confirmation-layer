package com.barclays.trade.confirmationlayer.service;

import com.barclays.trade.confirmationlayer.entity.ClientRules;
import com.barclays.trade.confirmationlayer.model.RuleKey;
import com.barclays.trade.confirmationlayer.model.TradeEvent;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Class to generate Rule Keys
 */
@Service
public class RuleKeyService {

    public RuleKey getRuleKeyForTradeEvent(TradeEvent event, List<ClientRules> clientRules) {
        //account can be a class itself in future
        String account = event.getAccount();
        HashSet<String> uniqueAccounts = clientRules.stream().map(ClientRules::getAccount).collect(Collectors.toCollection(HashSet::new));
        if (!uniqueAccounts.contains(event.getAccount())) {
            account = "ALL";
        }
        return RuleKey.builder().account(account).businessLine(event.getBusinessLine()).tradeNameLocation(event.getTradeNameLocation()).build();


    }
}
