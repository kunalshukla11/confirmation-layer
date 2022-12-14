package com.barclays.trade.confirmationlayer.entity;

import com.barclays.trade.confirmationlayer.model.BusinessLine;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


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


    @OneToMany(targetEntity = ClientRules.class , fetch = FetchType.EAGER , cascade = CascadeType.ALL)
    @JoinColumn(name= "CLIENT_NAME", referencedColumnName = "NAME")
    private List<ClientRules> clientRules;



}
