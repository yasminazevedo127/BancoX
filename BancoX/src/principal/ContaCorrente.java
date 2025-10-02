package principal;

public class ContaCorrente extends Conta implements Tributavel{

	public ContaCorrente(String cliente) {
		// TODO Auto-generated constructor stub
		super(cliente);
		this.tipo = "Corrente";
	}

	@Override
	public boolean sacar(double valor) {
		// TODO Auto-generated method stub
		if (valor > 0 && getSaldo() >= (valor * 1.05)) {
			setSaldo(getSaldo()-(valor * 1.05));
			return true;
		} else { 
			System.out.println("Saldo insuficiente ou valor inválido!");
		}
		return false;
	}

	@Override
	public void transferir(Conta destino, double valor) {
		// TODO Auto-generated method stub
		if (sacar(valor)) {
			destino.depositar(valor);
		}
	}

	@Override
	public double calculaTributos() {
		// TODO Auto-generated method stub
		return (getSaldo() * 0.01);
	}

	@Override
	public String getTipo() {
		// TODO Auto-generated method stub
		return "Corrente";
	}

}
