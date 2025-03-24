package com.itb.inf3bn.pizzariacurso25.model.entity;

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
@Table(name = "usuarios")
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 100)
    private String nome;
    @Column(nullable = true, length = 11)
    private String cpf;
    @Column(nullable = true, length = 45)
    private String username;
    @Column(nullable = true, length = 8)
    private String password;
    @Column(nullable = true)
    private String Logradouro;
    @Column(nullable = true)
    private String cep;
    @Column(nullable = true)
    private String bairro;
    @Column(nullable = true)
    private String cidade;
    @Column(nullable = true)
    private String uf;
    private boolean codStatus;
    @Column(nullable = true)
    private String tipoUsuario;


    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Telefone> telefones = new ArrayList<>();


    @Transient
    private String mensagemErro = "";
    @Transient
    private boolean isValid = true;
    public boolean validarUsuario() {

        return isValid;
    }

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Pedido> pedidos = new ArrayList<>();


    @Transient
    private String mensagemErro = "";
    @Transient
    private boolean isValid = true;
    public boolean validarUsuario() {

        return isValid;
    }

}
