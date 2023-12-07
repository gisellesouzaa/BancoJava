package banco;

import java.util.Comparator;
import java.util.function.ToIntFunction;

import banco.modelo.Banco;
import banco.modelo.Conta;

public class InterfaceFuncional {
	public static void main(String[] args) {

		Banco banco = new Banco();
		
		  	// Função do tipo ToIntFunction(interface funcional)
			// Tem o objetivo de obter os números das contas
			ToIntFunction<Conta> function = (Conta conta) -> {
				return conta.getNumero();
			};

			// Ordena a lista de contas
			// O critério de ordenação é definido pelo Comparator(interface funcional), que utiliza a função anterior.
			banco.getContas().sort(Comparator.comparingInt(function));

			//Percorrer as contas já ordenadas 
			for (Conta conta : banco.getContas()) {
				System.out.println(conta.getAgencia() + "/" + conta.getNumero());
			}
		
	}
}
