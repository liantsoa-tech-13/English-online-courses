package org.english.englishonlinecourse.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
@Entity
@Table(name = "payment")
public class Payment {
    @Id
    @Column(name = "payment_id", nullable = false, length = Integer.MAX_VALUE)
    private String paymentId;

    @Column(name = "amount")
    private Integer amount;

    @Column(name = "status", nullable = false, length = Integer.MAX_VALUE)
    private String status;

    @Column(name = "psp_id", nullable = false, length = Integer.MAX_VALUE)
    private String pspId;

    @Column(name = "psp_last_verification_instant")
    private OffsetDateTime pspLastVerificationInstant;

}