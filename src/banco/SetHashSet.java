package banco;

import java.util.HashSet;
import java.util.Set;

import banco.modelo.Pessoa;

public class SetHashSet {
	public static void main(String[] args) {

	Pessoa pessoa1 = new Pessoa("Joaquim da Silva", "12345678911");
	Pessoa pessoa2 = new Pessoa("Carolina da Silva", "12345678922");
	
	// Criação da coleção
	Set<Pessoa> colecaoPessoas = new HashSet<>();
	colecaoPessoas.add(pessoa1);
	colecaoPessoas.add(pessoa2);
	
	System.out.println("Coleção de pessoas formatada com toString: " + colecaoPessoas  +"\n");

	//Coleção não possui indices, por isso não é possível interar com For tradicional
	
	//Percorrer coleção com forEach / enhanced-for loop
	System.out.println("---forEach:");
	for (Pessoa pessoa : colecaoPessoas) {
		System.out.println(pessoa.getNome());
	}

	// Metódo contains - verifica se um elemento específico está presente na colecaoPessoas com base no hashCode e HashMaps
	boolean existePessoa = colecaoPessoas.contains(pessoa1);
	System.out.println("\n Existe '" + pessoa1.getNome() + "' na coleção? " + existePessoa);
	}
}
