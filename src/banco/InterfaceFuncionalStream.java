package banco;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class InterfaceFuncionalStream {

	public static void main(String[] args) {
		/* **** OUTRAS INTERFACES FUNCIONAIS: **** */

		System.out.println("-- Gerar 5 numéros aleatorios");
		Stream
				.generate(() -> new Random().nextInt()) // Supplier - não tem argumentos e gera um valor
				.limit(5).forEach(System.out::println); // Consumer - Recebe um valor, faz algo, mas não retorna nada

        System.out.println("\n -------------------------------------------------------");
		System.out.println("Filtrar numéros pares da lista, tranformando em double");
		
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
		list.stream()
				.filter(e -> e % 2 == 0) // Predicate - Recebe um valor, testa e retorna um booleano
				.map(e -> e.doubleValue()) // Function - Recebe um valor e retorna um valor
				.forEach(System.out::println); // Consumer

        System.out.println("\n-------------------------------------------------------");
		System.out.println("-- Pegar os numeros filtrados e soma-los com reduce");
		
		List<Integer> list2 = Arrays.asList(1, 2, 3, 4, 5);
		list2.stream().filter(e -> e % 2 == 0).map(e -> e.doubleValue()).reduce((e1, e2) -> e1 + e2) //UnaryOperator - Extende a function, mas valores de entrada e saída são do mesmo tipo
				.ifPresent(System.out::println); // reduce retorna Optional, por isso o forEach não funciona

	}

}
