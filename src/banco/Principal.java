package banco;

import java.math.BigDecimal;

import banco.modelo.Conta;
import banco.modelo.ContaEspecial;
import banco.modelo.ContaInvestimento;
import banco.modelo.Pessoa;
import banco.modelo.atm.CaixaEletronico;
import banco.modelo.pagamento.Boleto;
import banco.modelo.pagamento.Holerite;

public class Principal {

	public static void main(String[] args) {
		
		// Instanciando Pessoas: 
		Pessoa titular1 = new Pessoa();
		titular1.setNome("Giselle Souza"); 
		titular1.setDocumento("12312312311");
		
		Pessoa titular2 = new Pessoa();
		titular2.setNome("Gabriela Mistral"); 
		titular2.setDocumento("12312312312");
		
		//Instanciando Contas
		ContaInvestimento minhaConta = new ContaInvestimento(titular1, 0123, 987);			
		minhaConta.depositar(15_000);
		minhaConta.sacar(10_000 + 50);
		minhaConta.creditarRendimento(5);
		
		ContaEspecial suaConta = new ContaEspecial(titular2, 0345, 988, 5_000);

		//Caixa Eletronico
		CaixaEletronico caixaEletronico = new CaixaEletronico();
		caixaEletronico.imprimirSaldo(minhaConta);
		caixaEletronico.imprimirSaldo(suaConta);
		
		// Upcasting
		Conta conta = minhaConta; 
		conta.debitarTarifaMensal();
		
		//Documentos pagaveis
		Boleto boletoEscola = new Boleto(titular2, 1000);
        Holerite salarioFuncionario = new Holerite(titular2, 60, 160);
        
        
/*		System.out.println("Titular: " + minhaConta.getTitular().getNome());
		System.out.println("Saldo: " + minhaConta.getSaldoDisponivel());
		
		System.out.println("Titular: " + suaConta.getTitular().getNome());
		System.out.println("Saldo: " + suaConta.getSaldoDisponivel());
*/	
		
	}

}
