package Lista02.EX03;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
            ContaBancaria conta1 = new ContaBancaria();
            ContaBancaria conta2 = new ContaBancaria();

            Scanner sc = new Scanner(System.in);

            System.out.println("Insira as informações da primeira conta");
            System.out.println("Qual o número da conta? ");
            String numero1 = sc.next();

            conta1.setNumero(numero1);


            System.out.println("Quem é o titular da primeira conta?");
            String titularConta1 = sc.next();
            conta1.setTitular(titularConta1);

            //conta 2
            System.out.println("Insira as informações da segunda conta");
            
            System.out.println("Qual o número da conta? ");
            String numero2 = sc.next();

            conta2.setNumero(numero2);

            System.out.println("Quem é o titular da primeira conta?");
            String titularConta2 = sc.next();
            
            conta2.setTitular(titularConta2);
            
            conta1.depositar(1000);
            conta1.depositar(700);

            conta2.depositar(5000);

            conta2.sacar(3000);

            conta2.transferir(conta1, 1800);

            System.out.println("Movimentações feitas!");
            System.out.printf("A conta do %s ficou com saldo de %.2f \n",conta1.getTitular(), conta1.getSaldo());
            System.out.printf("A conta do %s ficou com saldo de %.2f",conta2.getTitular(), conta2.getSaldo());
            sc.close();
        }   
}
