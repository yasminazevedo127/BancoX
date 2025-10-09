package principal;

public abstract class Conta {
	private static int cont = 101;
	private int numero;
	private String cliente;
	private double saldo;
	protected String tipo;
	
	public Conta(String cliente) {
		this.numero = cont++;
        this.cliente = cliente;
        this.saldo = 0.0;
    }
	

	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public abstract String getTipo();
	public boolean depositar(double valor) {
		if (valor > 0) {
			this.saldo += valor;
			return true;
		}
		return false;
	}
	public abstract boolean sacar(double valor);
	public abstract boolean transferir(Conta destino, double valor);

	public void exibirConta() {
		System.out.println("Número da conta:" + numero);
	    System.out.println("Cliente: " + cliente);
	    System.out.println("Saldo: " + saldo);
	    System.out.println("Tipo da conta: " + tipo);
	    System.out.println("-------------------------");
	}
	
}
