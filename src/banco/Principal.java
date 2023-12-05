package banco;


public class Principal {

	public static void main(String[] args) {
		
		Pessoa titular1 = new Pessoa();
		titular1.nome = "Giselle Souza";
		titular1.documento = "12312312311";
		
		Conta minhaConta = new Conta(titular1, 0123, 987);			
		minhaConta.saldo = 15_000;
		minhaConta.depositar(5_000);
		minhaConta.sacar(10_000 + 50);
		
		Conta suaConta = new Conta();
		
		System.out.println("Titular: " + minhaConta.titular.nome);
		System.out.println("Saldo: " + minhaConta.saldo);
		
	}

}
