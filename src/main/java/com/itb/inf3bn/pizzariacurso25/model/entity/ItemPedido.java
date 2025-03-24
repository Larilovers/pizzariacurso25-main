package com.itb.inf3bn.pizzariacurso25.model.entity;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;

@Entity
@Data
@Table(name = "itemPedidos")
public class ItemPedido {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id;
    @Column(nullable = true, columnDefinition = "DECIMAL(5,2)")
    private double quantidadeItem;
    boolean codStatus;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long pedidoId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long produtoId;




     @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "produto_id", referencedColumnName = "id", nullable = true)
    private Produto produto;



    @Transient
    private String mensagemErro = "";
    @Transient
    private boolean isValid = true;
    public boolean validarItemPedido() {

        return isValid;
    }

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "pedido_id", referencedColumnName = "id", nullable = true)
    private Produto produto;



    @Transient
    private String mensagemErro = "";
    @Transient
    private boolean isValid = true;
    public boolean validarItemPedido() {

        return isValid;
    }

    


}
