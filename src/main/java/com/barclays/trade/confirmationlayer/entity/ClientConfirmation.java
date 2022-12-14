package com.barclays.trade.confirmationlayer.entity;

import com.barclays.trade.confirmationlayer.model.ConfirmationType;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Entity to store list of confirmation applicable to clients for various rules
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "CLIENT_CONFIRMATION")
public class ClientConfirmation implements Serializable {

    private static final long serialVersionUid =1L;

    @Id
    @GeneratedValue
    @Column(name =  "ID", nullable = false)
    private Long id;

    @Column(name = "CONFIRMATION_ID")
    private Long confirmationId;

    @Column(name = "CONFIRMATION_TYPE")
    @Enumerated(EnumType.STRING)
    private ConfirmationType confirmationType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name= "RULE_ID", referencedColumnName = "ID")
    private ClientRules clientRules;

}
