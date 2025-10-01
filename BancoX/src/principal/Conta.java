package principal;

public abstract class Conta {
	
	protected static int cont = 1;
	private int numero;
	private String cliente;
	private double saldo;
	protected int tipo;
	
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
	public int getTipo() {
		return tipo;
	}
	public void depositar(double valor) {
		if (valor > 0) {
			this.saldo += valor;
		}
	}
	public abstract void sacar(double valor);
	public abstract void transferir(Conta destino, double valor);

	public void exibirConta() {
		System.out.println("Número da conta:" + numero);
	    System.out.println("Cliente: " + cliente);
	    System.out.println("Saldo: " + saldo);
	    System.out.println("Tipo da conta: " + tipo);
	    System.out.println("-------------------------");
	}
	
}
