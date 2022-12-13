package com.barclays.trade.confirmationlayer.service;

/**
 * Generic Interface for providing notifications
 */
public interface Notifier<T> {
    /**
     * Provide notificaton for the message
     * @param message to be notified
     */
    void notify(T message);
}
