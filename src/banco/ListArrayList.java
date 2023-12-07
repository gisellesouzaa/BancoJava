package banco;

import java.util.ArrayList;
import java.util.List;

import banco.modelo.Pessoa;

public class ListArrayList {

	public static void main(String[] args) {
		Pessoa pessoa1 = new Pessoa("Joaquim da Silva", "12345678911");
		Pessoa pessoa2 = new Pessoa("Carolina da Silva", "12345678922");
		
		// Criação da lista
		List<Pessoa> arrayPessoas = new ArrayList<>();
		arrayPessoas.add(pessoa1);
		arrayPessoas.add(pessoa2);
		
		System.out.println("Lista de pessoas formatada com toString: " + arrayPessoas  +"\n");
		
		// Pegar item da lista pelo indice
		Pessoa pessoaSelecionada = arrayPessoas.get(0);

		System.out.println("Pessoa selecionada pelo indice: " + pessoaSelecionada +"\n");

		// Percorrer lista com For tradicional
		System.out.println("---For tradicional:");
		for (int i = 0; i < arrayPessoas.size(); i++) {
			System.out.println(arrayPessoas.get(i).getNome());
		}
	
		//Percorrer lista com forEach / enhanced-for loop
		System.out.println("---forEach:");
		for (Pessoa pessoa : arrayPessoas) {
			System.out.println(pessoa.getNome());
		}

		// Metódo contains - verifica se um elemento específico está presente na lista com base no metodo equals
		boolean existePessoa = arrayPessoas.contains(pessoa1);
		System.out.println("Existe '" + pessoa1.getNome() + "' na lista? " + existePessoa);

	}

}
