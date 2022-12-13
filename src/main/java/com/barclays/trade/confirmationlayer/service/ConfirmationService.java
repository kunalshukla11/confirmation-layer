package com.barclays.trade.confirmationlayer.service;

import com.barclays.trade.confirmationlayer.message.ConfirmationMessage;
import org.springframework.stereotype.Service;

/**
 * Class to process events and produce Confirmation notifications
 */
@Service
public class ConfirmationService implements Notifier<ConfirmationMessage> {
    @Override
    public void notify(ConfirmationMessage confirmationMessage) {

    }
}
