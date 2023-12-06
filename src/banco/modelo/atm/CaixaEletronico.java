package banco.modelo.atm;

import banco.modelo.Conta;

public class CaixaEletronico {
	
	  public void imprimirSaldo(Conta conta){
	        System.out.println("Conta:"+ conta.getAgencia() + "/" + conta.getNumero());
	        System.out.println("Titular:"+ conta.getTitular().getNome());
	        System.out.println("Saldo:"+ conta.getSaldo());
	        System.out.println("Saldo disponível:"+ conta.getSaldoDisponivel());
	  }
	

}
