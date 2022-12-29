package com.brazil.geek.model;

import static com.brazil.geek.helper.Utils.doubleToString;

public class Conta {
    private static int codigo = 1001;

    private final int numero;
    private Cliente cliente;
    private Double saldo = 0.0;
    private Double limite = 0.0;
    private Double saldoTotal;

    public Conta(Cliente cliente) {
        this.numero = codigo;
        this.cliente = cliente;
        codigo += 1;
        this.atualizaSaldoTotal();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Double getLimite() {
        return limite;
    }

    public void setLimite(Double limite) {
        this.limite = limite;
        this.atualizaSaldoTotal();
    }

    public Double getSaldoTotal() {
        return saldoTotal;
    }

    public int getNumero() {
        return numero;
    }

    private void atualizaSaldoTotal() {
        this.saldoTotal = this.getSaldo() + this.getLimite();
    }

    @Override
    public String toString() {
        return "Numero da Conta: " + this.getNumero() +
                "\nCliente: " + this.cliente.getNome() +
                "\nSaldo Total: " + doubleToString(this.getSaldoTotal());
    }

    public void depositar(Double value) {
        if (value > 0) {
            this.saldo = this.getSaldo() + value;
            this.atualizaSaldoTotal();
            System.out.println("Deposito efetuado com sucesso!");
        } else System.out.println("Erro ao efetuar deposito. Tente novamente!");
    }

    public void sacar(Double value) {
        if (value > 0 && this.getSaldoTotal() >= value) {
            if (this.getSaldo() >= value)
                this.saldo = this.getSaldo() - value;
            else {
                Double restante = this.getSaldo() - value; // 500 - 600 -> -100
                this.limite = this.getLimite() + restante; // 200 - -100 ->
                this.saldo = 0.0;
            }
            this.atualizaSaldoTotal();
            System.out.println("Saque efetuado com sucesso!");
        } else System.out.println("Saque nao realizado. Tente novamente.");
    }

    public void transferir(Conta destino, Double value) {
        if (value > 0 && this.getSaldoTotal() >= value) {
            if (this.getSaldo() >= value)
                this.saldo = this.getSaldo() - value;
            else {
                Double restante = this.getSaldo() - value;
                this.limite = this.getLimite() + restante;
                this.saldo = 0.0;
            }
            destino.saldo = destino.getSaldo() + value;
            this.atualizaSaldoTotal();
            destino.atualizaSaldoTotal();
            System.out.println("Transferencia realizada com sucesso!");
        } else System.out.println("Transferencia nao realizada. Tente novamente!");
    }

}
