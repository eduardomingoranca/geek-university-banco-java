package com.brazil.geek.model;

import java.util.Date;

import static com.brazil.geek.helper.Utils.dateToString;

public class Cliente {
    private static int contador = 101;

    private final int codigo;
    private String nome;
    private String email;
    private String cpf;
    private Date dataNascimento;
    private final Date dataCadastro;

    public Cliente(String nome, String email, String cpf, Date dataNascimento) {
        this.codigo = contador;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.dataCadastro = new Date();
        contador += 1;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    @Override
    public String toString() {
        return "Codigo: " + this.getCodigo() +
                "\nNome: " + this.getNome() +
                "\nEmail: " + this.getEmail() +
                "\nCPF: " + this.getCpf() +
                "\nData de Nascimento: " + dateToString(this.getDataNascimento()) +
                "\nData de Cadastro: " + dateToString(this.getDataCadastro());
    }

}
