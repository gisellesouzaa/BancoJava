package banco.modelo;

import java.util.Objects;

public class Conta {
	
	private Pessoa titular;
	private int agencia;
	private int numero;
	private double saldo;
	
	public Conta(){
	}
	
	public Conta(Pessoa titular, int agencia, int numero){
		Objects.requireNonNull(titular); //Titular não pode ser nulo
		this.titular = titular;
		this.agencia = agencia;
        this.numero = numero;
	}
	
	public void depositar(double valor) {
		if (valor <= 0) {
			throw new IllegalArgumentException("Valor deve ser maior que 0");
		}
			
		saldo = saldo + valor;
	}
	
	public void sacar(double valor) {
		if (valor <= 0) {
			throw new IllegalArgumentException("Valor deve ser maior que 0");
		}
		
		if (saldo - valor < 0) {
			throw new IllegalStateException("Saldo insuficiente");
		}
			
		saldo = saldo - valor;
	}

	void sacar(double valor, double taxaSaque) {
		sacar(valor + taxaSaque);
	}

	public Pessoa getTitular() {
		return titular;
	}

	public void setTitular(Pessoa titular) {
		this.titular = titular;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public double getSaldo() {
		return saldo;
	}
	
	public double getSaldoDisponivel() {
		return getSaldo();
	}

}
