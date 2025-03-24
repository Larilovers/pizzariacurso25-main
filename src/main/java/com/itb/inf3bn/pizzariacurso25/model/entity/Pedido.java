package com.itb.inf3bn.pizzariacurso25.model.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;


@Entity
@Data
@Table(name = "pedidos")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 100)
    private LocalDateTime dataHoraCompra;
    @Column(nullable = true, columnDefinition = "DECIMAL(5,2)")
    private double valorTotal;
    @Column(nullable = false, length = 100)
    private String status;
    boolean codStatus;
    @Column(nullable = false, length = 100)
    private LocalDateTime dataHoraEntrega;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long usuarioId;
    @Column(nullable = false, length = 100)
    private String numeroPedido;

     @OneToMany(mappedBy = "pedidos", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<ItemPedido> itemPedidos = new ArrayList<>();


    @Transient
    private String mensagemErro = "";
    @Transient
    private boolean isValid = true;
    public boolean validarPedido() {

        return isValid;
    }



}
