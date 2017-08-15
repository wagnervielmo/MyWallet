package net.vielmond.mywallet.entidades;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by root on 06/08/17.
 */

public class Parcelas implements Serializable {

    private Integer id_parcela;
    private Integer id_compra_fk;
    private Integer id_carteira_fk;
    private Integer id_usuario_fk;
    private Integer numero_parcela;
    private Float valor_parcela;
    private Date data_parcela;
    private Boolean mostrar;

    public Integer getId_parcela() {
        return id_parcela;
    }

    public void setId_parcela(Integer id_parcela) {
        this.id_parcela = id_parcela;
    }

    public Integer getId_compra_fk() {
        return id_compra_fk;
    }

    public void setId_compra_fk(Integer id_compra_fk) {
        this.id_compra_fk = id_compra_fk;
    }

    public Integer getId_carteira_fk() {
        return id_carteira_fk;
    }

    public void setId_carteira_fk(Integer id_carteira_fk) {
        this.id_carteira_fk = id_carteira_fk;
    }

    public Integer getId_usuario_fk() {
        return id_usuario_fk;
    }

    public void setId_usuario_fk(Integer id_usuario_fk) {
        this.id_usuario_fk = id_usuario_fk;
    }

    public Integer getNumero_parcela() {
        return numero_parcela;
    }

    public void setNumero_parcela(Integer numero_parcela) {
        this.numero_parcela = numero_parcela;
    }

    public Float getValor_parcela() {
        return valor_parcela;
    }

    public void setValor_parcela(Float valor_parcela) {
        this.valor_parcela = valor_parcela;
    }

    public Date getData_parcela() {
        return data_parcela;
    }

    public void setData_parcela(Date data_parcela) {
        this.data_parcela = data_parcela;
    }

    public Boolean getMostrar() {
        return mostrar;
    }

    public void setMostrar(Boolean mostrar) {
        this.mostrar = mostrar;
    }
}
