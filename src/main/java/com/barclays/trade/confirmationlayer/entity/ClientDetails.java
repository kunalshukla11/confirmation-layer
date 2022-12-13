package com.barclays.trade.confirmationlayer.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;


/**
 * Entity class to represent Client information
 * Used the details for the client
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "CLIENT_DETAILS")
public class ClientDetails implements Serializable {

    private static final long serialVersionUid =1L;

    @Id
    @GeneratedValue
    @Column(name =  "ID", nullable = false)
    private Long id;

    @Column(name = "PRIORITY")
    private Integer priority;

    @Column(name = "NAME")
    private String name;

    @Column(name = "BUSINESS_LINE")
    private String businessLine;

    @OneToMany
    @JoinColumn(name= "RULE_ID", referencedColumnName = "ID")
    private List<ClientRules> clientRules;

    @OneToMany
    @JoinColumn(name= "CONFIRMATION_ID", referencedColumnName = "ID")
    private List<ClientConfirmation> clientConfirmations;


}
