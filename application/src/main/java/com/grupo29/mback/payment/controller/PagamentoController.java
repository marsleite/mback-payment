package com.grupo29.mback.payment.controller;

import com.grupo29.mback.payment.entities.CartaoCredito;
import com.grupo29.mback.payment.entities.Pagamento;
import com.grupo29.mback.payment.exception.CartaoException;
import com.grupo29.mback.payment.usecase.CreateCartaoUseCase;
import com.grupo29.mback.payment.usecase.CreatePagamentoUseCase;
import com.grupo29.mback.payment.usecase.FindCartaoUseCase;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mback/pagamento")
@Log4j2
public class PagamentoController {
    @Autowired
    private CreatePagamentoUseCase createPagamentoUseCase;
    @Autowired
    private FindCartaoUseCase findCartaoUseCase;
    @Autowired
    private CreateCartaoUseCase createCartaoUseCase;


    @PostMapping
    public ResponseEntity<Pagamento> createPagamento(@RequestBody Pagamento pagamento) {
        try {
            return ResponseEntity.ok(createPagamentoUseCase.execute(pagamento));
        } catch (CartaoException e) {
            log.error(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }



    @GetMapping("/cartao/{id}")
    public ResponseEntity<CartaoCredito> getCartaoById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(findCartaoUseCase.execute(id));
        } catch (CartaoException e) {
            log.error(e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/cartao")
    public ResponseEntity<CartaoCredito> createCartao(@RequestBody CartaoCredito cartao) {
        try {
            return ResponseEntity.ok(createCartaoUseCase.execute(cartao));
        } catch (CartaoException e) {
            log.error(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }


}
