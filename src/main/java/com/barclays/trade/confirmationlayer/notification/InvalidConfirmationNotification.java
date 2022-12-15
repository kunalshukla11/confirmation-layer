package com.barclays.trade.confirmationlayer.notification;

import com.barclays.trade.confirmationlayer.message.ConfirmationMessage;
import com.barclays.trade.confirmationlayer.message.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class InvalidConfirmationNotification implements Notifier<Message>{
    private static final Logger LOGGER = LoggerFactory.getLogger(InvalidConfirmationNotification.class);

    @Override
    public void notify(Message message) {
        LOGGER.info("Giving notification for Summary Type");
        ConfirmationMessage msg = (ConfirmationMessage) message;
        LOGGER.info("Notifying for --{}", msg.toString());
    }
}
