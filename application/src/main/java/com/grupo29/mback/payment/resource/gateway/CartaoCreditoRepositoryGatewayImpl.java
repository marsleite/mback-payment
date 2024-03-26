package com.grupo29.mback.payment.resource.gateway;

import com.grupo29.mback.payment.entities.CartaoCredito;
import com.grupo29.mback.payment.gateway.CartaoCreditoRepositoryGateway;
import com.grupo29.mback.payment.resource.repository.entity.CartaoCreditoEntity;
import com.grupo29.mback.payment.resource.repository.spring.CartaoCreditoRepositorySpring;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CartaoCreditoRepositoryGatewayImpl implements CartaoCreditoRepositoryGateway {

    private final CartaoCreditoRepositorySpring cartaoCreditoRepositorySpring;

    @Autowired
    public CartaoCreditoRepositoryGatewayImpl(CartaoCreditoRepositorySpring cartaoCreditoRepositorySpring) {
        this.cartaoCreditoRepositorySpring = cartaoCreditoRepositorySpring;
    }

    @Override
    public CartaoCredito createCartao(CartaoCredito cartaoCredito) {
        CartaoCreditoEntity cartaoCreditoEntity = CartaoCreditoEntity.fromDomain(cartaoCredito);
        CartaoCreditoEntity savedCartaoCreditoEntity = cartaoCreditoRepositorySpring.save(cartaoCreditoEntity);
        return savedCartaoCreditoEntity.toDomain();
    }

    @Override
    public CartaoCredito getCartaoById(Long id) {
        return cartaoCreditoRepositorySpring.findById(id).orElseThrow().toDomain();
    }
}