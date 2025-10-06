package principal;
import java.util.Scanner;
import java.util.ArrayList;


public class BancoX {

	private static Scanner leitor = new Scanner(System.in);
	private static ArrayList<Conta> listaDeContas = new ArrayList<Conta>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int acao;
        boolean sair = false;
        while (sair != true) {
            System.out.println("\n====== BancoX ======");
            System.out.println(
            	    "1. Criar Conta\n" +
            	    "2. Realizar Depósito\n" +
            	    "3. Realizar Saque\n" +
            	    "4. Realizar Transferência\n" + 
            	    "5. Listar Contas\n" +
            	    "6. Calcular Total de Tributos\n" +
            	    "7. Sair\n" +
            	    "Escolha uma opção: "
            	);
            acao = leitor.nextInt();
            leitor.nextLine(); 

            switch (acao) {
                case 1:
                	System.out.print("Nome do cliente: ");
                    String nome = leitor.nextLine();
                    System.out.print("Tipo de conta (1-Corrente, 2-Poupança): ");
                    int intTipo = leitor.nextInt();
                    Conta novaConta;
                    if (intTipo == 1) {
                        novaConta = new ContaCorrente(nome);
                    } else {
                        novaConta = new ContaPoupanca(nome);
                    }
                    listaDeContas.add(novaConta);
                   
                    System.out.println("Conta criada. Número da conta: " + novaConta.getNumero());
                	break;
                case 2:
                	System.out.print("Número da conta: ");
                    int numero = leitor.nextInt();
                    Conta conta = buscarConta(numero);
                
                    if (conta != null) {
                        System.out.print("Valor: ");
                        conta.depositar(leitor.nextDouble());
                    } else {
                        System.out.println("Conta não encontrada!");
                    }
                	break;
                case 3: 
                	System.out.print("Número da conta: ");
                    Conta sConta = buscarConta(leitor.nextInt());
                    if (sConta != null) {
                        System.out.print("Valor: ");
                        double valor = leitor.nextDouble();
                        sConta.sacar(valor);
                    } else {
                        System.out.println("Conta não encontrada!");
                    }
                	break;
                case 4:
                	System.out.print("Conta origem: ");
                	int origemNum = leitor.nextInt();
                    Conta origem = buscarConta(origemNum);
                    
                    System.out.print("Conta destino: ");
                    int destinoNum = leitor.nextInt();
                    Conta destino = buscarConta(destinoNum);
                    
                    if (origem != null && destino != null) {
                    	System.out.print("Valor: ");
                    	double valor = leitor.nextDouble();
                    	origem.transferir(destino, valor);
                    }
                    break;
                case 5:
                	listarContas(listaDeContas);
                	break;
                case 6:
                	calcularTotalDeTributos(listaDeContas);
                case 7: 
                	sair = true;
                	break;
                default: 
                	System.out.println("Opção inválida.");
            }
        }
	}
	
	public static void calcularTotalDeTributos(ArrayList<Conta> listaDeContas) {
		double totalTributos = 0.0;
		
		for (Conta conta : listaDeContas) {
			if (conta instanceof Tributavel) {
				Tributavel contaTributavel = (Tributavel) conta;
				totalTributos += contaTributavel.calculaTributos();
			}
			}
		System.out.println("\n========================================");
		System.out.println("Total de tributos a recolher: R$ " + totalTributos);
		System.out.println("========================================");
	}

	
	private static void listarContas(ArrayList<Conta> listaDeContas) {
		System.out.println("\n===== LISTA DE CONTAS =====");
        for (Conta conta: listaDeContas) {
            conta.exibirConta();
        }
	}
	
	
	private static Conta buscarConta(int numero) {
        for (Conta c : listaDeContas) {
            if (c.getNumero() == numero) {
                return c;
            }
        }
        return null;
    }
}
