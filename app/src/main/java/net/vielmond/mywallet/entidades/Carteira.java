package net.vielmond.mywallet.entidades;

import java.io.InputStream;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by root on 06/08/17.
 */

public class Carteira implements Serializable {

    private Integer id_carteira;
    private Integer id_usuario_fk;
    private String nome_carteira;
    private String descricao;
    private Boolean mostrar;
    private Integer ordem;
    private Timestamp log;
    private InputStream imagem;

    public Integer getId_carteira() {
        return id_carteira;
    }

    public void setId_carteira(Integer id_carteira) {
        this.id_carteira = id_carteira;
    }

    public Integer getId_usuario_fk() {
        return id_usuario_fk;
    }

    public void setId_usuario_fk(Integer id_usuario_fk) {
        this.id_usuario_fk = id_usuario_fk;
    }

    public String getNome_carteira() {
        return nome_carteira;
    }

    public void setNome_carteira(String nome_carteira) {
        this.nome_carteira = nome_carteira;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Boolean getMostrar() {
        return mostrar;
    }

    public void setMostrar(Boolean mostrar) {
        this.mostrar = mostrar;
    }

    public Integer getOrdem() {
        return ordem;
    }

    public void setOrdem(Integer ordem) {
        this.ordem = ordem;
    }

    public Timestamp getLog() {
        return log;
    }

    public void setLog(Timestamp log) {
        this.log = log;
    }

    public InputStream getImagem() {
        return imagem;
    }

    public void setImagem(InputStream imagem) {
        this.imagem = imagem;
    }
}
