package com.barclays.trade.confirmationlayer.entity;

import com.barclays.trade.confirmationlayer.model.BusinessLine;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Entity to save client rules
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "CLIENT_RULES" )
public class ClientRules  implements Serializable {

    private static final long serialVersionUid = 1L;

    @Id
    @GeneratedValue
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "CLIENT_NAME")
    private String clientName;

    @Column(name = "RULE_ORDER")
    private Integer ruleOrder;

    @Column(name = "RULE_IDENTIFIER")
    private String ruleIdentifier;

    @Column(name = "ACCOUNT")
    private String account;

    @Column(name = "BUSINESS_LINE")
    @Enumerated(EnumType.STRING)
    private BusinessLine businessLine;


}
