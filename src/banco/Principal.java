package banco;

public class Principal {

	public static void main(String[] args) {
		
		Pessoa titular1 = new Pessoa();
		titular1.nome = "Giselle Souza";
		titular1.documento = "12312312311";
		
		Conta minhaConta = new Conta();			
		minhaConta.titular = titular1;
		minhaConta.agencia = 0123;
		minhaConta.numero = 987;
		minhaConta.saldo = 15_000;
		
		System.out.println("Titular: " + minhaConta.titular.nome);
		System.out.println("Saldo: " + minhaConta.saldo);

	}

}
