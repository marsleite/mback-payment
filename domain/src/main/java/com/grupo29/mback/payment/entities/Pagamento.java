package com.grupo29.mback.payment.entities;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class Pagamento {
    private Long id;
    private String vendedorId;
    private CartaoCredito cartaoCredito;
    private BigDecimal valor;

}
