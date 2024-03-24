package com.grupo29.mback.payment.resource.repository.entity;

import com.grupo29.mback.payment.entities.Pagamento;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Builder
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pagamento")
public class PagamentoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String vendedorId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cartao_id", referencedColumnName = "id")
    private CartaoCreditoEntity cartaoCredito;

    private BigDecimal valor;

    public static PagamentoEntity fromDomain(Pagamento pagamento) {
        return PagamentoEntity.builder()
                .id(pagamento.getId())
                .vendedorId(pagamento.getVendedorId())
                .cartaoCredito(CartaoCreditoEntity.fromDomain(pagamento.getCartaoCredito()))
                .valor(pagamento.getValor())
                .build();
    }

    public Pagamento toDomain() {
        return Pagamento.builder()
                .id(this.id)
                .vendedorId(this.vendedorId)
                .cartaoCredito(this.cartaoCredito.toDomain())
                .valor(this.valor)
                .build();
    }
}