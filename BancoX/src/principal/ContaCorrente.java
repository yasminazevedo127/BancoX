package principal;

public class ContaCorrente extends Conta implements Tributavel{

	public ContaCorrente(String cliente) {
		// TODO Auto-generated constructor stub
		super(cliente);
		this.tipo = 1;
	}

	@Override
	public void sacar(double valor) {
		// TODO Auto-generated method stub
		if (valor > 0 && getSaldo() >= (valor * 1.05)) {
			setSaldo(getSaldo()-(valor * 1.05));
		} else { 
			System.out.println("Saldo insuficiente ou valor inválido!");
		}
	}

	@Override
	public void transferir(Conta destino, double valor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double calculaTributos() {
		// TODO Auto-generated method stub
		return (getSaldo() * 0.01);
	}

}
