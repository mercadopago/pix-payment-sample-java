package com.mercadopago.sample.dto;

public class PixPaymentResponseDTO {
    private Long id;
    private String status;
    private String detail;
    private String qrCodeBase64;
    private String qrCode;

    public PixPaymentResponseDTO(Long id, String status, String detail, String qrCodeBase64, String qrCode) {
        this.id = id;
        this.status = status;
        this.detail = detail;
        this.qrCodeBase64 = qrCodeBase64;
        this.qrCode = qrCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getQrCodeBase64() {
        return qrCodeBase64;
    }

    public void setQrCodeBase64(String qrCodeBase64) {
        this.qrCodeBase64 = qrCodeBase64;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }
}
