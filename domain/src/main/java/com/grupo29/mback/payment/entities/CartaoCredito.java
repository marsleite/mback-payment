package com.grupo29.mback.payment.entities;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class CartaoCredito {

    private Long id;
    private String clienteId;
    private String numero;
    private Date validade;
    private String cvv;
}
