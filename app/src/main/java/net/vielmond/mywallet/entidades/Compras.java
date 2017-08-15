package net.vielmond.mywallet.entidades;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by root on 06/08/17.
 */

public class Compras implements Serializable {

    private Integer id_compra;
    private Integer id_tipo_compra_fk;
    private Integer id_carteira_fk;
    private String desc_tipo_compra_fk;
    private Integer id_usuario_fk;
    private Integer id_categoria_fk;
    private String desc_categoria_fk;
    private String titulo;
    private String descricao;
    private Integer numero_parcelas;
    private Date data_compra;
    private String local_compra;
    private Float valor_total_compra;
    private Float desconto;
    private Boolean mostrar;

    public Integer getId_compra() {
        return id_compra;
    }

    public void setId_compra(Integer id_compra) {
        this.id_compra = id_compra;
    }

    public Integer getId_tipo_compra_fk() {
        return id_tipo_compra_fk;
    }

    public void setId_tipo_compra_fk(Integer id_tipo_compra_fk) {
        this.id_tipo_compra_fk = id_tipo_compra_fk;
    }

    public Integer getId_carteira_fk() {
        return id_carteira_fk;
    }

    public void setId_carteira_fk(Integer id_carteira_fk) {
        this.id_carteira_fk = id_carteira_fk;
    }

    public String getDesc_tipo_compra_fk() {
        return desc_tipo_compra_fk;
    }

    public void setDesc_tipo_compra_fk(String desc_tipo_compra_fk) {
        this.desc_tipo_compra_fk = desc_tipo_compra_fk;
    }

    public Integer getId_usuario_fk() {
        return id_usuario_fk;
    }

    public void setId_usuario_fk(Integer id_usuario_fk) {
        this.id_usuario_fk = id_usuario_fk;
    }

    public Integer getId_categoria_fk() {
        return id_categoria_fk;
    }

    public void setId_categoria_fk(Integer id_categoria_fk) {
        this.id_categoria_fk = id_categoria_fk;
    }

    public String getDesc_categoria_fk() {
        return desc_categoria_fk;
    }

    public void setDesc_categoria_fk(String desc_categoria_fk) {
        this.desc_categoria_fk = desc_categoria_fk;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getNumero_parcelas() {
        return numero_parcelas;
    }

    public void setNumero_parcelas(Integer numero_parcelas) {
        this.numero_parcelas = numero_parcelas;
    }

    public Date getData_compra() {
        return data_compra;
    }

    public void setData_compra(Date data_compra) {
        this.data_compra = data_compra;
    }

    public String getLocal_compra() {
        return local_compra;
    }

    public void setLocal_compra(String local_compra) {
        this.local_compra = local_compra;
    }

    public Float getValor_total_compra() {
        return valor_total_compra;
    }

    public void setValor_total_compra(Float valor_total_compra) {
        this.valor_total_compra = valor_total_compra;
    }

    public Float getDesconto() {
        return desconto;
    }

    public void setDesconto(Float desconto) {
        this.desconto = desconto;
    }

    public Boolean getMostrar() {
        return mostrar;
    }

    public void setMostrar(Boolean mostrar) {
        this.mostrar = mostrar;
    }
}
