package com.grupo29.mback.payment.usecase;

import com.grupo29.mback.payment.entities.CartaoCredito;
import com.grupo29.mback.payment.exception.CartaoException;
import com.grupo29.mback.payment.gateway.CartaoCreditoRepositoryGateway;

public class CreateCartaoUseCase {

    private final CartaoCreditoRepositoryGateway cartaoCreditoRepositoryGateway;

    public CreateCartaoUseCase(CartaoCreditoRepositoryGateway cartaoCreditoRepositoryGateway) {
        this.cartaoCreditoRepositoryGateway = cartaoCreditoRepositoryGateway;
    }

    public CartaoCredito execute(CartaoCredito cartaoCredito) throws CartaoException {
        if (!cartaoExists(cartaoCredito)) {
            return cartaoCreditoRepositoryGateway.createCartao(cartaoCredito);
        } else {
            throw new CartaoException("Cartão já cadastrado.");
        }
    }

    private boolean cartaoExists(CartaoCredito cartaoCredito) {
        return cartaoCreditoRepositoryGateway.getCartaoById(cartaoCredito.getId()) != null;
    }
}
