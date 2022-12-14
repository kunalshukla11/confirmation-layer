package com.barclays.trade.confirmationlayer.utils;

/**
 * Generic Validator
 * @param <T>
 */
public interface Validator<T> {
    void validate(T t);
}
