package banco;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import banco.modelo.Banco;
import banco.modelo.Conta;
import banco.modelo.ContaEspecial;
import banco.modelo.ContaInvestimento;
import banco.modelo.Pessoa;
import banco.modelo.atm.CaixaEletronico;
import banco.modelo.enums.TipoPessoa;
import banco.modelo.excecao.SaldoInsuficienteException;
import banco.modelo.pagamento.Boleto;
import banco.modelo.pagamento.Holerite;

public class Principal {

	public static void main(String[] args) {
		
		// Instanciando Pessoas: 
		Pessoa titular1 = new Pessoa();
		titular1.setNome("Giselle Souza"); 
		titular1.setDocumento("12312312311");
		titular1.setRendimentoAnual(new BigDecimal("15000"));

		//Enum
		titular1.setTipo(TipoPessoa.JURIDICA);
		System.out.println("Tipo de Pessoa:" + titular1.getTipo());
		
		//Data e Hora
		titular1.setDataUltimaAtualizacao(LocalDateTime.parse("2023-12-06T10:00"));
		System.out.println("Última atualização: " + titular1.getDataUltimaAtualizacao());

		
		Pessoa titular2 = new Pessoa();
		titular2.setNome("Gabriela Mistral"); 
		titular2.setDocumento("12312312312");
		
		//Acessando informações toString
		System.out.println("toString: " + titular2.toString()); //Também funciona sem o '.toString()'
		
		//Instanciando Contas
		ContaInvestimento minhaConta = new ContaInvestimento(titular1, 0123, 987);		
		try {
		minhaConta.depositar(new BigDecimal("0"));
		minhaConta.creditarRendimento(new BigDecimal("5"));
		} catch (IllegalArgumentException e) {
			System.out.println("Erro ao executar operação: " + e.getMessage());
		}
		
		ContaEspecial suaConta = new ContaEspecial(titular2, 0345, 988, new BigDecimal("0"));

		//Tratando exceptions
		try {
		minhaConta.sacar(new BigDecimal("10000").add(new BigDecimal("50")));
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
        Holerite salarioFuncionario = new Holerite(titular2, new BigDecimal("60"), 5);
        caixaEletronico.pagar(salarioFuncionario, minhaConta);
        salarioFuncionario.imprimirRecibo();
		} catch (SaldoInsuficienteException e) {
			System.out.println("Erro ao executar operação na conta: " + e.getMessage());
		}
		
        Boleto boletoEscola = new Boleto(titular2, new BigDecimal("100"));
        
        try {
		caixaEletronico.pagar(boletoEscola, minhaConta);
        caixaEletronico.estornarPagamento(boletoEscola, minhaConta);
        } catch (SaldoInsuficienteException e) {
			System.out.println("Erro ao executar operação na conta: " + e.getMessage());
		}
      
        boletoEscola.imprimirRecibo();
        
        //Optional
        Banco banco = new Banco();

        BigDecimal saldo = banco.buscar(123, 2222)
        		.map(Conta::getSaldo)
        		.orElse(BigDecimal.ZERO);
        System.out.println(saldo);
        
        
        //Sem Optional
        Banco banco2 = new Banco();
        Conta contaEncontrada2 = banco2.buscar2(123, 2222);
        
        if (contaEncontrada2 != null) {
        	System.out.println(contaEncontrada2.getSaldo());
        }

        /* 
        Conta contaEncontrada = banco.buscar(123, 123)
        		.orElseThrow(() -> new RuntimeException("CONTA NÃO ENCONTRADA."));
        System.out.println(contaEncontrada.getSaldo()); */
		
	}

}
