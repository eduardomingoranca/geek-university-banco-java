package com.brazil.geek.view;

import com.brazil.geek.model.Cliente;
import com.brazil.geek.model.Conta;

import static com.brazil.geek.helper.Utils.stringToDate;

public class Teste {

    public static void main(String[] args) {

        Cliente cliente = new Cliente("Felicity Calhoun",
                "felicity@gmail.com",
                "123.456.789.01",
                stringToDate("04/07/1971"));

        Cliente cliente2 = new Cliente("Alice Wheeler",
                "alice@gmail.com",
                "432.765.098.21",
                stringToDate("01/01/1968"));

//        System.out.println(cliente);
//        System.out.println();
//        System.out.println(cliente2);

        Conta c101 = new Conta(cliente);
        Conta c102 = new Conta(cliente2);

//        Depositando um valor positivo
        c101.depositar(500.00);
        c102.depositar(500.00);

//        Depositando um valor 0
//        c101.depositar(0.00);
//        c102.depositar(0.00);

//        Depositando um valor negativo
//        c101.depositar(-500.00);
//        c102.depositar(-500.00);

//        Tentando sacar um valor no saldo suficiente
//        c101.sacar(300.0);

//        Tentando sacar um valor 0
//        c101.sacar(0.0);

//        Tentando sacar um valor negativo
//        c101.sacar(-100.0);

//        Setando um limite para a c101
        c101.setLimite(200.00);

//        Tentando sacar um valor maior que o saldo
//        c101.sacar(600.00);

        c101.transferir(c102, 100.00);

        System.out.println(c101);
        System.out.println();
        System.out.println(c102);

    }
}
