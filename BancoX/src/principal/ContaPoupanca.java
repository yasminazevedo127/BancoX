package principal;

public class ContaPoupanca extends Conta{

	public ContaPoupanca(String cliente) {
		// TODO Auto-generated constructor stub
		super(cliente);
		this.tipo = "Poupança";
	}

	@Override
	public boolean sacar(double valor) {
		// TODO Auto-generated method stub
		if (valor > 0 && getSaldo() >= valor) {
			setSaldo(getSaldo() - valor);
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
	public String getTipo() {
		// TODO Auto-generated method stub
		return "Poupança";
	}

}
