package banco;

import java.math.BigDecimal;
import java.util.stream.Stream;

import banco.modelo.Banco;
import banco.modelo.Conta;

public class ApiStreams {

	public static void main(String[] args) {
		Banco banco = new Banco();
		
		//Depositar 10 reais nas constas e imprimir contas com novos saldos
		Stream<Conta> stream1 = banco.getContas().stream();

		stream1.forEach(conta -> {
			conta.depositar(new BigDecimal("10"));
			System.out.println(conta.getAgencia() + "/" + conta.getNumero() + " = " + conta.getSaldo());
		});
		
		//Filtrar contas com saldo acima de R$ 500
		Stream<Conta> stream2 = banco.getContas().stream()
				.filter(conta -> conta.getSaldo().compareTo(new BigDecimal("500")) > 0);

		//Filtrar por contas com numero maior que 300
		Stream<Conta> stream3 = stream2.filter(conta -> conta.getNumero() > 8000);
		stream3.forEach(conta -> {
			System.out.println(conta.getAgencia() + "/" + conta.getNumero() + " = " + conta.getSaldo());

		});
	}

}
