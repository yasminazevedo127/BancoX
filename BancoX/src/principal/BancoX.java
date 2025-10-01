package principal;
import java.util.Scanner;
import java.util.ArrayList;


public class BancoX {

	private static Scanner leitor = new Scanner(System.in);
	private static ArrayList<Conta> contas = new ArrayList<Conta>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BancoX banco = new BancoX();
		int acao;
        boolean sair = false;
        while (sair != true) {
            System.out.println("\n====== Menu Principal ======");
            System.out.println(
            		"Escolha uma opção:\n" +
            	    "1. Criar Conta\n" +
            	    "2. Realizar Depósito\n" +
            	    "3. Realizar Saque\n" +
            	    "4. Realizar Transferência " + 
            	    "5. Listar Contas" +
            	    "6. Calcular Total de Tributos" +
            	    "7. Sair"
            	);
            acao = leitor.nextInt();
            leitor.nextLine(); 

            switch (acao) {
                case 1:
                	System.out.print("Nome do cliente: ");
                    String nome = leitor.nextLine();
                    System.out.print("Tipo de conta (1-Corrente, 2-Poupança): ");
                    int intTipo = leitor.nextInt();
                    Conta conta = (intTipo == 1) ? new ContaCorrente(nome) : new ContaPoupanca(nome);
                    banco.addConta(conta);
                    System.out.println("Conta criada: " + conta);
                    System.out.println("Conta criada. Número da conta (índice): " + (contas.size() - 1));
                	break;
                case 2:
                	System.out.print("Número da conta: ");
                    int numero = leitor.nextInt();
                    System.out.print("Valor: ");
                    double valor = leitor.nextDouble();
                    contas.get(numero).depositar(valor);
                	break;
                case 3: 
                	System.out.print("Número da conta: ");
                    int num = leitor.nextInt();
                    System.out.print("Valor: ");
                    double val = leitor.nextDouble();
                    contas.get(num).sacar(val);
                	break;
                case 4:
                	System.out.print("Conta origem: ");
                    int origem = leitor.nextInt();
                    System.out.print("Conta destino: ");
                    int destino = leitor.nextInt();
                    System.out.print("Valor: ");
                    double v = leitor.nextDouble();
                    contas.get(origem).transferir(contas.get(destino), v);
                    break;
                case 5:
                	listarContas(contas);
                	break;
                case 6:
                	calcularTotalDeTributos(contas);
                case 7: 
                	sair = true;
                	break;
                default: 
                	System.out.println("Opção inválida.");
            }
        }
	}
	
	public static void calcularTotalDeTributos(ArrayList<Conta> contas) {
		double totalTributos = 0.0;
		
		for (Conta conta : contas) {
		
		
		Tributavel contaTributavel = (Tributavel) conta;
		totalTributos += contaTributavel.calculaTributos();
		}
	
		System.out.println("\n========================================");
		System.out.println("Total de tributos a recolher: R$ " + totalTributos);
		System.out.println("========================================");
	}
	
	public void addConta(Conta conta) {
        contas.add(conta);
    }
	
	private static void listarContas(ArrayList<Conta> contas) {
		System.out.println("\n===== LISTA DE CONTAS =====");
        for (Conta conta: contas) {
            conta.exibirConta();
        }
      
	}

}
