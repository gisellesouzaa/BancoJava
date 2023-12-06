package banco.modelo.pagamento;

public interface DocumentoPagavel {

	double getValorTotal();
	boolean estaPago();
	void quitarPagamento();
}
