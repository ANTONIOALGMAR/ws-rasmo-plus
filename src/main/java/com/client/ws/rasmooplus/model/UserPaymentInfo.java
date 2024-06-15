package com.client.ws.rasmooplus.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "user_payment_info")
public class UserPaymentInfo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_payment_id")
    private Long id;

    @Column(name = "card_number")
    private String cardNumber;

    @Column(name = "card_experation_month")
    private Long cardExperationMonth;

    @Column(name = "card_experation_yars")
    private Long cardExperationYars;

    @Column(name = "card_security_code")
    private String cardSecurityCode;

    private BigDecimal price;

    @Column(name = "dt_payment")
    private LocalDate dtPayment;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

}
