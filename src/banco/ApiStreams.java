package banco;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;

import banco.modelo.Banco;
import banco.modelo.Conta;
import banco.modelo.Pessoa;

public class ApiStreams {

	public static void main(String[] args) {
		Banco banco = new Banco();
		
	    List<Pessoa> titulares = banco.getContas().stream()
                .map(Conta::getTitular)
                .distinct()
                .toList();
        System.out.printf("Titulares:" + titulares);
        
        System.out.println("\n-------------------------------------------------------");

        BigDecimal saltoTotal = banco.getContas().stream()
        		.map(Conta::getSaldo)
        		.reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.printf("Salto total de todas as contas no projeto:" + saltoTotal);

        System.out.println("\n-------------------------------------------------------");

        banco.getContas().stream()
                .filter(conta -> conta.getSaldo().compareTo(new BigDecimal("50")) > 0)
                .filter(conta -> conta.getNumero() > 200)
                .map(Conta::getTitular)
                .distinct() //Base no equals
                .forEach(System.out::println);

        System.out.println("-------------------------------------------------------");

		
		banco.getContas().stream()
				.filter(conta -> conta.getSaldo().compareTo(new BigDecimal("10")) > 0)
				.filter(conta -> conta.getNumero() > 100)
				.sorted(Comparator.comparingInt(Conta::getNumero))
				.forEach(conta -> {
			System.out.println(conta.getAgencia() + "/" + conta.getNumero() + " = " + conta.getSaldo());
		});
	}

}
