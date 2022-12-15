package com.barclays.trade.confirmationlayer.message;

import com.barclays.trade.confirmationlayer.model.ConfirmationDto;
import com.barclays.trade.confirmationlayer.model.Fault;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.List;

/**
 * This class represents the output of trade events
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ConfirmationMessage extends Message {


    private Fault fault;

    private List<ConfirmationDto> confirmationDtoList;

    @Override
    public String toString() {
        return "ConfirmationMessage{" +
                "fault=" + fault +
                ", confirmationDtoList=" + confirmationDtoList +
                '}';
    }
}
