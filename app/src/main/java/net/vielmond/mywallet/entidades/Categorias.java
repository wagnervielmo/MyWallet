package net.vielmond.mywallet.entidades;

import java.io.Serializable;

/**
 * Created by root on 06/08/17.
 */

public class Categorias implements Serializable {

    private Integer id_categoria;
    private Integer id_usuario_fk;
    private String descricao;

    public Integer getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(Integer id_categoria) {
        this.id_categoria = id_categoria;
    }

    public Integer getId_usuario_fk() {
        return id_usuario_fk;
    }

    public void setId_usuario_fk(Integer id_usuario_fk) {
        this.id_usuario_fk = id_usuario_fk;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
