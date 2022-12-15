package com.barclays.trade.confirmationlayer.dao;

import com.barclays.trade.confirmationlayer.entity.ClientConfirmation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Dao to get confirmations for specific rules for client
 */
public interface ClientConfirmationDao extends JpaRepository<ClientConfirmation, Long> {

    @Query("Select c FROM ClientConfirmation c where  c.clientRules =:id")
    List<ClientConfirmation> getClientConfirmationsByRuleId(Long id);
}
