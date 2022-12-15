package com.barclays.trade.confirmationlayer.notification;

/**
 * Generic Interface for providing notifications
 */
public interface Notifier<T> {
    /**
     * Provide notification for the message
     * @param message to be notified
     */
    void notify(T message);
}
