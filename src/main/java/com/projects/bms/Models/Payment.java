package com.projects.bms.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Payment extends BaseModel {

    private String refNo;

    @Enumerated(EnumType.ORDINAL)
    private PaymentProvider provider;

    @Enumerated(EnumType.ORDINAL)
    private PaymentMethod method;

    @Enumerated(EnumType.ORDINAL)
    private PaymentStatus status;

    private int amount;


}
