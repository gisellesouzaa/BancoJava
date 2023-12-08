package banco.modelo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Banco {
	
	private List<Conta> arrayContas = new ArrayList<>();

    public Banco() {
        Pessoa pessoa1 = new Pessoa("Carlos", "98765432111");
        Pessoa pessoa2 = new Pessoa("Mara", "98765432122");

        Conta conta1 = new ContaInvestimento(pessoa1, 123, 7945);
        Conta conta2 = new ContaInvestimento(pessoa1, 222, 4321);
        Conta conta3 = new ContaInvestimento(pessoa2, 333, 8234);
        Conta conta4 = new ContaEspecial(pessoa1, 123, 5888, new BigDecimal(100));
        Conta conta5 = new ContaEspecial(pessoa2, 123, 2222, new BigDecimal(200));

        conta1.depositar(new BigDecimal("120"));
        conta2.depositar(new BigDecimal("150"));
        conta3.depositar(new BigDecimal("500"));
        conta5.depositar(new BigDecimal("12000"));

        arrayContas.add(conta1);
        arrayContas.add(conta2);
        arrayContas.add(conta3);
        arrayContas.add(conta4);
        arrayContas.add(conta5);
    }

    public List<Conta> getContas() {
        return arrayContas;
    }
    
    /*   Optional:   */
    public Optional<Conta> buscar(int agencia, int numeroConta) {
        for (Conta conta : getContas()) {
            if (conta.getAgencia() == agencia 
            		&& conta.getNumero() == numeroConta) {
                return Optional.of(conta);
            }
        }
        return Optional.empty();
    }
    
    /* Metodo sem optional:  */
    public Conta buscar2(int agencia, int numeroConta) {
        for (Conta conta : getContas()) {
            if (conta.getAgencia() == agencia 
            		&& conta.getNumero() == numeroConta) {
                return conta;
            }
        }
        return null;
    }

}
