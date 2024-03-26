package com.grupo29.mback.payment.beans;

import com.grupo29.mback.payment.gateway.CartaoCreditoRepositoryGateway;
import com.grupo29.mback.payment.gateway.PagamentoRepositoryGateway;
import com.grupo29.mback.payment.usecase.CreateCartaoUseCase;
import com.grupo29.mback.payment.usecase.CreatePagamentoUseCase;
import com.grupo29.mback.payment.usecase.FindCartaoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanDomains {

    @Bean
    public CreatePagamentoUseCase createPagamento(PagamentoRepositoryGateway pagamentoRepositoryGateway, CartaoCreditoRepositoryGateway cartaoCreditoRepositoryGateway) {
        return new CreatePagamentoUseCase(pagamentoRepositoryGateway, cartaoCreditoRepositoryGateway);
    }

    @Bean
    public CreateCartaoUseCase createCartao(CartaoCreditoRepositoryGateway cartaoCreditoRepositoryGateway) {
        return new CreateCartaoUseCase(cartaoCreditoRepositoryGateway);
    }

    @Bean
    public FindCartaoUseCase findCartao(CartaoCreditoRepositoryGateway cartaoCreditoRepositoryGateway) {
        return new FindCartaoUseCase(cartaoCreditoRepositoryGateway);
    }

}

