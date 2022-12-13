package com.barclays.trade.confirmationlayer.processor;

/**
 * Generic Event processor to process different events
 */
public interface EventProcessor<T> {

    /**
     * Process the event
     * @param event to process
     */
    void process(T event);
}
