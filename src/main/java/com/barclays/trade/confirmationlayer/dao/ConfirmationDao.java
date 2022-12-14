package com.barclays.trade.confirmationlayer.dao;

import com.barclays.trade.confirmationlayer.entity.Confirmation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Dao class to retrieve update {@link Confirmation}
 */
public interface ConfirmationDao extends JpaRepository<Confirmation, Long> {
}
