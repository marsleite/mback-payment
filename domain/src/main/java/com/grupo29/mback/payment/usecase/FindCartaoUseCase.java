package com.grupo29.mback.payment.usecase;

import com.grupo29.mback.payment.entities.CartaoCredito;
import com.grupo29.mback.payment.exception.CartaoException;
import com.grupo29.mback.payment.gateway.CartaoCreditoRepositoryGateway;

public class FindCartaoUseCase {
    private final CartaoCreditoRepositoryGateway cartaoCreditoRepositoryGateway;


    public FindCartaoUseCase(CartaoCreditoRepositoryGateway cartaoCreditoRepositoryGateway) {
        this.cartaoCreditoRepositoryGateway = cartaoCreditoRepositoryGateway;
    }

    public CartaoCredito execute(Long id) throws CartaoException {
        CartaoCredito cartao = cartaoCreditoRepositoryGateway.getCartaoById(id);
        if (cartao == null) {
            throw new CartaoException("Cartão não encontrado.");
        }
        return cartao;
    }
}
