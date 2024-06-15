package com.client.ws.rasmooplus.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

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

    public UserPaymentInfo() {
    }

    public UserPaymentInfo(Long id, String cardNumber, Long cardExperationMonth, Long cardExperationYars, String cardSecurityCode, BigDecimal price, LocalDate dtPayment, User user) {
        this.id = id;
        this.cardNumber = cardNumber;
        this.cardExperationMonth = cardExperationMonth;
        this.cardExperationYars = cardExperationYars;
        this.cardSecurityCode = cardSecurityCode;
        this.price = price;
        this.dtPayment = dtPayment;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Long getCardExperationMonth() {
        return cardExperationMonth;
    }

    public void setCardExperationMonth(Long cardExperationMonth) {
        this.cardExperationMonth = cardExperationMonth;
    }

    public Long getCardExperationYars() {
        return cardExperationYars;
    }

    public void setCardExperationYars(Long cardExperationYars) {
        this.cardExperationYars = cardExperationYars;
    }

    public String getCardSecurityCode() {
        return cardSecurityCode;
    }

    public void setCardSecurityCode(String cardSecurityCode) {
        this.cardSecurityCode = cardSecurityCode;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDate getDtPayment() {
        return dtPayment;
    }

    public void setDtPayment(LocalDate dtPayment) {
        this.dtPayment = dtPayment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
