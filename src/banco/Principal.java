package banco;

public class Principal {

	public static void main(String[] args) {
		
		Conta minhaConta = new Conta();
		
		minhaConta.nomeTitular = "Giselle Souza";
		minhaConta.agencia = 0123;
		minhaConta.numero = 987;
		minhaConta.saldo = 15_000;
		
		System.out.println("Titular: " + minhaConta.nomeTitular);
		System.out.println("Saldo: " + minhaConta.saldo);

	}

}
