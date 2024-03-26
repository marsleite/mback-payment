package com.grupo29.mback.payment.gateway;

import com.grupo29.mback.payment.entities.CartaoCredito;

public interface CartaoCreditoRepositoryGateway {
    CartaoCredito createCartao(CartaoCredito CartaoCredito);

    CartaoCredito getCartaoById(Long id);

}
