package com.barclays.trade.confirmationlayer.message;

import com.barclays.trade.confirmationlayer.model.ConfirmationDto;

/**
 * This class represents the output of trade events
 */
public class ConfirmationMessage implements Message<ConfirmationDto> {


    private ConfirmationDto confirmation;
    @Override
    public void setMessage(ConfirmationDto confirmation) {
        this.confirmation = confirmation;
    }

    @Override
    public ConfirmationDto getMessage() {
        return this.confirmation;
    }
}
