package com.financas.pessoais.domain.transacao.model;

import com.financas.pessoais.enums.TipoTransacao;
import com.financas.pessoais.domain.categoria.model.Categoria;
import com.financas.pessoais.domain.usuario.model.Usuario;
import jakarta.persistence.*;

@Entity

public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TipoTransacao tipoTransacao;

    private Double valor;
    private String descricao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    private Categoria categoria;

    public Transacao() {
    }

    public Transacao(TipoTransacao tipoTransacao, Double valor, String descricao, Usuario usuario, Categoria categoria) {
        this.tipoTransacao = tipoTransacao;
        this.valor = valor;
        this.descricao = descricao;
        this.usuario = usuario;
        this.categoria = categoria;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoTransacao getTipoTransacao() {
        return tipoTransacao;
    }

    public void setTipoTransacao(TipoTransacao tipoTransacao) {
        this.tipoTransacao = tipoTransacao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
