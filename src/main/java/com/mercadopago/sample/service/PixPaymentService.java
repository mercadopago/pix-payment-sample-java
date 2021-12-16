package com.mercadopago.sample.service;

import com.google.gson.JsonElement;
import com.mercadopago.sample.dto.PixPaymentResponseDTO;
import com.mercadopago.sample.exception.MercadoPagoException;
import com.mercadopago.sample.dto.PixPaymentDTO;
import com.mercadopago.MercadoPago;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.Payment;
import com.mercadopago.resources.datastructures.payment.Identification;
import com.mercadopago.resources.datastructures.payment.Payer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PixPaymentService {
    @Value("${mercado_pago_sample_access_token}")
    private String mercadoPagoAccessToken;

    public PixPaymentResponseDTO processPayment(PixPaymentDTO pixPaymentDTO) {
        try {
            MercadoPago.SDK.setAccessToken(mercadoPagoAccessToken);

            Payment payment = new Payment();

            payment.setTransactionAmount(pixPaymentDTO.getTransactionAmount())
                    .setDescription(pixPaymentDTO.getProductDescription())
                    .setPaymentMethodId("pix")
                    .setPayer(new Payer()
                            .setEmail(pixPaymentDTO.getPayer().getEmail())
                            .setFirstName(pixPaymentDTO.getPayer().getFirstName())
                            .setLastName(pixPaymentDTO.getPayer().getLastName())
                            .setIdentification(new Identification()
                                    .setType(pixPaymentDTO.getPayer().getIdentification().getType())
                                    .setNumber(pixPaymentDTO.getPayer().getIdentification().getNumber())
                            )
                    );

            Payment createdPayment = payment.save();

            this.validatePaymentResult(createdPayment);

            PixPaymentResponseDTO pixPaymentResponseDTO = new PixPaymentResponseDTO(
                    createdPayment.getId(),
                    String.valueOf(createdPayment.getStatus()),
                    createdPayment.getStatusDetail(),
                    createdPayment.getPointOfInteraction().getTransactionData().getQrCodeBase64(),
                    createdPayment.getPointOfInteraction().getTransactionData().getQrCode()
            );

            return pixPaymentResponseDTO;
        } catch (MPException exception) {
            System.out.println(exception.getMessage());
            throw new MercadoPagoException(exception.getMessage());
        }
    }

    private void validatePaymentResult(Payment createdPayment) throws MPException {
        if(createdPayment.getId() == null) {
            String errorMessage = "Unknown error cause";

            if(createdPayment.getLastApiResponse() != null) {
                String sdkErrorMessage = createdPayment.getLastApiResponse().getJsonElementResponse().getAsJsonObject().get("message").getAsString();
                errorMessage = sdkErrorMessage != null ? sdkErrorMessage : errorMessage;
            }

            throw new MPException(errorMessage);
        }
    }
}
