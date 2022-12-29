package com.brazil.geek.view;

import com.brazil.geek.model.Cliente;
import com.brazil.geek.model.Conta;

import java.util.ArrayList;
import java.util.Scanner;

import static com.brazil.geek.helper.Utils.pause;
import static com.brazil.geek.helper.Utils.stringToDate;
import static java.lang.Integer.parseInt;
import static java.lang.System.exit;
import static java.lang.System.identityHashCode;

public class Banco {

    static String nome = "GEEK BANK";
    static Scanner teclado = new Scanner(System.in);
    static ArrayList<Conta> contas;

    public static void main(String[] args) {
        contas = new ArrayList<>();
        menu();
    }

    private static void menu() {
        System.out.println("=============================");
        System.out.println("=========== ATM =============");
        System.out.println("========= " + nome +  " =========");
        System.out.println("=============================");
        System.out.println("| 1 | CRIAR CONTA           |");
        System.out.println("| 2 | EFETUAR SAQUE         |");
        System.out.println("| 3 | EFETUAR DEPOSITO      |");
        System.out.println("| 4 | EFETUAR TRANSFERENCIA |");
        System.out.println("| 5 | LISTAR CONTAS         |");
        System.out.println("| 6 | SAIR DO SISTEMA       |");

        int opcao = 0;

        try {
            System.out.print("Informe uma opcao: ");
            opcao = parseInt(teclado.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Por favor, informe uma opcao valida.");
            pause(1);
            menu();
        }

        switch (opcao) {
            case 1 -> criarConta();
            case 2 -> efetuarSaque();
            case 3 -> efetuarDeposito();
            case 4 -> efetuarTransferencia();
            case 5 -> listarContas();
            case 6 -> {
                System.out.println("Ate a proxima!");
                pause(2);
                exit(0);
            }
            default -> {
                System.out.println("Opcao invalida!");
                pause(2);
                menu();
            }
        }
    }

    private static void criarConta() {
        System.out.println("Informe os dados do cliente: \n");

        System.out.print("Nome do cliente: ");
        String nome = teclado.nextLine();

        System.out.print("Email do cliente: ");
        String email = teclado.nextLine();

        System.out.print("CPF do cliente: ");
        String cpf = teclado.nextLine();

        System.out.print("Data de nascimento do cliente: ");
        String dataNascimento = teclado.nextLine();

        Cliente cliente = new Cliente(nome, email, cpf, stringToDate(dataNascimento));
        Conta conta = new Conta(cliente);

        contas.add(conta);

        System.out.println("Conta criada com sucesso!");
        System.out.println("Dados da conta criada: ");
        System.out.println(conta);
        System.out.println();

        pause(4);
        menu();
    }

    private static void efetuarSaque() {
        System.out.print("Informe o numero da conta: ");
        int numero = teclado.nextInt();

        Conta conta = buscarContaPorNumero(numero);

        if (conta != null) {
            System.out.print("Informe o valor para saque R$ ");
            Double valor = teclado.nextDouble();

            conta.sacar(valor);
        } else System.out.println("Nao foi encontrada a conta numero " + numero);

        pause(3);
        menu();
    }

    private static void efetuarDeposito() {
        System.out.print("Informe o numero da conta: ");
        int numero = teclado.nextInt();

        Conta conta = buscarContaPorNumero(numero);

        if (conta != null) {
            System.out.print("Informe o valor de deposito R$ ");
            Double valor = teclado.nextDouble();

            conta.depositar(valor);
        } else System.out.println("Nao foi encontrada a conta numero " + numero);

        pause(3);
        menu();
    }

    private static void efetuarTransferencia() {
        System.out.print("Informe o numero da conta: ");
        int numeroOrigem = teclado.nextInt();

        Conta contaOrigem =  buscarContaPorNumero(numeroOrigem);

        if (contaOrigem != null) {
            System.out.print("Informe o numero da conta destino: ");
            int numeroDestino = teclado.nextInt();

            Conta contaDestino = buscarContaPorNumero(numeroDestino);

            if (contaDestino != null) {
                System.out.print("Informe o valor da transferencia R$ ");
                Double valor = teclado.nextDouble();

                contaOrigem.transferir(contaDestino, valor);
            } else System.out.println("A conta destino numero " + numeroDestino + " nao foi encontrada.");
        } else System.out.println("Nao foi encontrada a conta numero " + numeroOrigem);

        pause(3);
        menu();
    }

    private static void listarContas() {
        if (contas.size() > 0) {
            System.out.println("Listagem de contas");
            System.out.println();

            for (Conta conta: contas) {
                System.out.println(conta);
                System.out.println();
                pause(1);
            }
            System.out.println();
        } else System.out.println("Nao existem contas cadastradas ainda.");

        pause(3);
        menu();
    }

    private static Conta buscarContaPorNumero(int numero) {
        Conta c = null;
        if (contas.size() > 0) {
            for (Conta conta : contas) {
                if (conta.getNumero() == numero) {
                    c = conta;
                }
            }
        }
        return c;
    }

}
