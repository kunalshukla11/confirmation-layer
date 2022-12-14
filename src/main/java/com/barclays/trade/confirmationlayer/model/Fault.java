package com.barclays.trade.confirmationlayer.model;

import lombok.*;

/**
Class to represent error fields
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
public class Fault {

    private String errorMsg;
    private String errorType;
}
