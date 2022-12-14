package com.barclays.trade.confirmationlayer.message;

import com.barclays.trade.confirmationlayer.model.Fault;

/**
 * Error message pojo to notify users of Errors
 */
public class FaultMessage implements Message<Fault> {
    private Fault fault;
    @Override
    public void setMessage(Fault fault) {

    }

    @Override
    public Fault getMessage() {
        return this.fault;
    }
}
