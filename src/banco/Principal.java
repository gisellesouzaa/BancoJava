package banco;

import banco.modelo.Conta;
import banco.modelo.ContaEspecial;
import banco.modelo.ContaInvestimento;
import banco.modelo.Pessoa;
import banco.modelo.atm.CaixaEletronico;
import banco.modelo.excecao.SaldoInsuficienteException;
import banco.modelo.pagamento.Boleto;
import banco.modelo.pagamento.Holerite;

public class Principal {

	public static void main(String[] args) {
		
		// Instanciando Pessoas: 
		Pessoa titular1 = new Pessoa();
		titular1.setNome("Giselle Souza"); 
		titular1.setDocumento("12312312311");
		
		//Autoboxing e unboxing 
		titular1.setRendimentoAnual(15_000d);
		double rendimento = titular1.getRendimentoAnual();
		System.out.println("Rendimento anual convertido para tipo primitivo(double): " + rendimento);

		
		Pessoa titular2 = new Pessoa();
		titular2.setNome("Gabriela Mistral"); 
		titular2.setDocumento("12312312312");
		
		//Instanciando Contas
		ContaInvestimento minhaConta = new ContaInvestimento(titular1, 0123, 987);		
		try {
		minhaConta.depositar(0);
		minhaConta.creditarRendimento(5);
		} catch (IllegalArgumentException e) {
			System.out.println("Erro ao executar operação: " + e.getMessage());
		}
		
		ContaEspecial suaConta = new ContaEspecial(titular2, 0345, 988, 0);

		//Tratando exceptions
		try {
		minhaConta.sacar(10_000 + 50);
		} catch (SaldoInsuficienteException e) {
			System.out.println("Erro ao executar operação na conta: " + e.getMessage());
		}
		

		//Caixa Eletronico
		CaixaEletronico caixaEletronico = new CaixaEletronico();
		caixaEletronico.imprimirSaldo(minhaConta);
		caixaEletronico.imprimirSaldo(suaConta);
		
		// Upcasting
		Conta conta = minhaConta; 
		try {
		conta.debitarTarifaMensal();
		
		//Documentos pagáveis
        Holerite salarioFuncionario = new Holerite(titular2, 60, 5);
        caixaEletronico.pagar(salarioFuncionario, minhaConta);
        salarioFuncionario.imprimirRecibo();
		} catch (SaldoInsuficienteException e) {
			System.out.println("Erro ao executar operação na conta: " + e.getMessage());
		}
		
        Boleto boletoEscola = new Boleto(titular2, 100);
        
        try {
		caixaEletronico.pagar(boletoEscola, minhaConta);
        caixaEletronico.estornarPagamento(boletoEscola, minhaConta);
        } catch (SaldoInsuficienteException e) {
			System.out.println("Erro ao executar operação na conta: " + e.getMessage());
		}
      
        boletoEscola.imprimirRecibo();
        
/*		System.out.println("Titular: " + minhaConta.getTitular().getNome());
		System.out.println("Saldo: " + minhaConta.getSaldoDisponivel());
		
		System.out.println("Titular: " + suaConta.getTitular().getNome());
		System.out.println("Saldo: " + suaConta.getSaldoDisponivel());
*/	
		
	}

}
