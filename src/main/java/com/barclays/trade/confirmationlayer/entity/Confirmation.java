package com.barclays.trade.confirmationlayer.entity;

import com.barclays.trade.confirmationlayer.model.ConfirmationType;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Entity to store static confirmation types
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "CONFIRMATION")
public class Confirmation implements Serializable {

    private static final long serialVersionUid =1L;

    @Id
    @GeneratedValue
    @Column(name =  "ID", nullable = false)
    private Long id;

    @Column(name = "CONFIRMATION_TYPE")
    @Enumerated(EnumType.STRING)
    private ConfirmationType confirmationType;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "DELIVERY_MODES")
    private String deliveryModes;

    @Column(name = "BUSINESS_LINES")
    private String businessLines;

}
