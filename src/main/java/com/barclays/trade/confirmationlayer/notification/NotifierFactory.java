package com.barclays.trade.confirmationlayer.notification;

import com.barclays.trade.confirmationlayer.message.Message;
import com.barclays.trade.confirmationlayer.model.ConfirmationType;
import org.springframework.stereotype.Service;

/**
 * Notifier factory
 */
@Service
public class NotifierFactory {

    private final SummaryNotification summaryNotification;
    private final XontroNotification xontroNotification;

    public NotifierFactory(SummaryNotification summaryNotification, XontroNotification xontroNotification) {
        this.summaryNotification = summaryNotification;
        this.xontroNotification = xontroNotification;
    }

    public  Notifier<Message> getNotifier(ConfirmationType confirmationType){

        if(ConfirmationType.SUMMARY.equals(confirmationType)){
            return this.summaryNotification;
        } else if (ConfirmationType.XONTRO.equals(confirmationType)) {
            return this.xontroNotification;
        }else{
            throw new  UnsupportedOperationException("No valid confirmations");
        }
    }
}
