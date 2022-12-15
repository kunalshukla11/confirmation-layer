package com.barclays.trade.confirmationlayer.dao;

import com.barclays.trade.confirmationlayer.entity.ClientDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Dao to retrieve update/ client details
 */
public interface ClientDetailsDao extends JpaRepository<ClientDetails, Long> {

    @Query("Select c FROM ClientDetails c where c.name =:name")
    ClientDetails findByClientName(String name);
}
