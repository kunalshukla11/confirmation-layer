package com.barclays.trade.confirmationlayer.message;

/**
 * Generic interface to represent different types of message
 */
public interface Message<T> {

    void setMessage(T T);
    T getMessage();
}
