package banco;

public class Conta {
	
	Pessoa titular;
	int agencia;
	int numero;
	double saldo;
	
	void depositar(double valor) {
		saldo = saldo + valor;
	}

}
