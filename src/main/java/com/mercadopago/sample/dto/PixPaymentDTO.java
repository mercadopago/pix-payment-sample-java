package com.mercadopago.sample.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

public class PixPaymentDTO {
    @NotNull
    private Float transactionAmount;

    @NotNull
    @JsonProperty("description")
    private String productDescription;

    @NotNull
    private PayerDTO payer;

    public PixPaymentDTO() {
    }

    public Float getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(Float transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public PayerDTO getPayer() {
        return payer;
    }

    public void setPayer(PayerDTO payer) {
        this.payer = payer;
    }
}
