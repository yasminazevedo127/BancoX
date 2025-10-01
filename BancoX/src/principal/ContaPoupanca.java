package principal;

public class ContaPoupanca extends Conta{

	public ContaPoupanca(String cliente) {
		// TODO Auto-generated constructor stub
		super(cliente);
		this.tipo = 2;
	}

	@Override
	public void sacar(double valor) {
		// TODO Auto-generated method stub
		if (valor > 0 && getSaldo() >= valor) {
			setSaldo(getSaldo() - valor);
		} else { 
			System.out.println("Saldo insuficiente ou valor inválido!");
		}
	}

	@Override
	public void transferir(Conta destino, double valor) {
		// TODO Auto-generated method stub
		
	}

}
