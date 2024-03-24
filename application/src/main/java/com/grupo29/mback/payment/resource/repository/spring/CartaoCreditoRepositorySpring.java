package com.grupo29.mback.payment.resource.repository.spring;

import com.grupo29.mback.payment.resource.repository.entity.CartaoCreditoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartaoCreditoRepositorySpring extends JpaRepository<CartaoCreditoEntity, Long> {
}
