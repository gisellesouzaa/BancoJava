package banco;

import java.util.Comparator;

import banco.modelo.Banco;
import banco.modelo.Conta;

public class InterfaceFuncional {
	public static void main(String[] args) {

		Banco banco = new Banco();
		
		  	// Função do tipo ToIntFunction(interface funcional)
			// Tem o objetivo de obter os números das contas e ordená-las com base no número
			banco.getContas().sort(Comparator.comparingInt(conta -> conta.getNumero()));

			//Percorrer as contas já ordenadas 
			for (Conta conta : banco.getContas()) {
				System.out.println(conta.getAgencia() + "/" + conta.getNumero());
			}
		
	}
}
