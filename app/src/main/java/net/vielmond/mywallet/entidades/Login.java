package net.vielmond.mywallet.entidades;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by root on 06/08/17.
 */

public class Login implements Serializable{

    private Integer id_usuario = 0;
    private String nome;
    private String cpf;
    private Date dt_nascimento;
    private String Str_dt_nascimento;
    private String login;
    private String senha;
    private Boolean ativo;
    private Timestamp log;

    public Integer getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDt_nascimento() {
        return dt_nascimento;
    }

    public void setDt_nascimento(Date dt_nascimento) {
        this.dt_nascimento = dt_nascimento;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public Timestamp getLog() {
        return log;
    }

    public void setLog(Timestamp log) {
        this.log = log;
    }

    public String getStr_dt_nascimento() {
        return Str_dt_nascimento;
    }

    public void setStr_dt_nascimento(String str_dt_nascimento) {
        Str_dt_nascimento = str_dt_nascimento;
    }
}
