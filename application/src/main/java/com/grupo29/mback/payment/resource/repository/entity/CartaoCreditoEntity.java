package com.grupo29.mback.payment.resource.repository.entity;

import com.grupo29.mback.payment.entities.CartaoCredito;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cartao")
public class CartaoCreditoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String clienteId;
    private String numero;
    private Date validade;
    private String cvv;

    public static CartaoCreditoEntity fromDomain(CartaoCredito cartaoCredito) {
        return CartaoCreditoEntity.builder()
                .id(cartaoCredito.getId())
                .clienteId(cartaoCredito.getClienteId())
                .numero(cartaoCredito.getNumero())
                .validade(cartaoCredito.getValidade())
                .cvv(cartaoCredito.getCvv())
                .build();
    }

    public CartaoCredito toDomain() {
        return CartaoCredito.builder()
                .id(this.id)
                .clienteId(this.clienteId)
                .numero(this.numero)
                .validade(this.validade)
                .cvv(this.cvv)
                .build();
    }
}