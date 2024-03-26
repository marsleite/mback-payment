package com.grupo29.mback.payment.usecase;

import com.grupo29.mback.payment.entities.Pagamento;
import com.grupo29.mback.payment.exception.CartaoException;
import com.grupo29.mback.payment.gateway.CartaoCreditoRepositoryGateway;
import com.grupo29.mback.payment.gateway.PagamentoRepositoryGateway;

public class CreatePagamentoUseCase {

    private final PagamentoRepositoryGateway pagamentoRepositoryGateway;
    private final CartaoCreditoRepositoryGateway cartaoCreditoRepositoryGateway;

    public CreatePagamentoUseCase(PagamentoRepositoryGateway pagamentoRepositoryGateway, CartaoCreditoRepositoryGateway cartaoCreditoRepositoryGateway) {
        this.pagamentoRepositoryGateway = pagamentoRepositoryGateway;
        this.cartaoCreditoRepositoryGateway = cartaoCreditoRepositoryGateway;
    }

    public Pagamento execute(Pagamento pagamento) throws CartaoException {
        if (cartaoCreditoRepositoryGateway.getCartaoById(pagamento.getCartaoCredito().getId()) == null) {
            throw new CartaoException("Necessário realizar o cadastro do cartão de crédito.");
        }
        return pagamentoRepositoryGateway.createPagamento(pagamento);
    }

}
