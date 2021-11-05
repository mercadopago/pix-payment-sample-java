package com.mercadopago.sample.dto;

import javax.validation.constraints.NotNull;

public class PayerDTO {
    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private String email;

    @NotNull
    private PayerIdentificationDTO identification;

    public PayerDTO() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public PayerIdentificationDTO getIdentification() {
        return identification;
    }

    public void setIdentification(PayerIdentificationDTO identification) {
        this.identification = identification;
    }
}
