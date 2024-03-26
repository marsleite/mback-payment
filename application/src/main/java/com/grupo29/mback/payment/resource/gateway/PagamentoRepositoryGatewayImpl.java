package com.grupo29.mback.payment.resource.gateway;

import com.grupo29.mback.payment.entities.Pagamento;
import com.grupo29.mback.payment.gateway.PagamentoRepositoryGateway;
import com.grupo29.mback.payment.resource.repository.entity.PagamentoEntity;
import com.grupo29.mback.payment.resource.repository.spring.PagamentoRepositorySpring;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PagamentoRepositoryGatewayImpl implements PagamentoRepositoryGateway {

    private final PagamentoRepositorySpring pagamentoRepositorySpring;

    @Autowired
    public PagamentoRepositoryGatewayImpl(PagamentoRepositorySpring pagamentoRepositorySpring) {
        this.pagamentoRepositorySpring = pagamentoRepositorySpring;
    }

    @Override
    public Pagamento createPagamento(Pagamento pagamento) {
        PagamentoEntity pagamentoEntity = PagamentoEntity.fromDomain(pagamento);
        PagamentoEntity savedPagamentoEntity = pagamentoRepositorySpring.save(pagamentoEntity);
        return savedPagamentoEntity.toDomain();
    }

}