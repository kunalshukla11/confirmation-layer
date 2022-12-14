package com.barclays.trade.confirmationlayer.model;

import lombok.*;

/**
 * Pojo class for confirmation
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
public class ConfirmationDto {
    private String message;
    private String msgType;
    private String msgMedium;
}
