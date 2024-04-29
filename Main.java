import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		
		// definicao do input
		Scanner input = new Scanner(System.in);
		
		// declaracao das variaveis usadas
		int escolha;
		boolean fim = false; // variaveis para os loops
		String atual = "";
		String nTarefa;
		String menu = """
*** CONTROLE DE TAREFAS ***
1 - Iniciar a próxima tarefa da fila.
2 - Inserir uma tarefa na fila.
3 - Verificar qual é a próxima tarefa na fila.
4 - Exibir quantas tarefas ainda faltam fazer.
5 - Remover todas as tarefas da fila.
6 - Sair.
""";
		
		// Criacao da fila fora do loop
		fila f1 = new fila(4);
		
		// loop de execucao
		while (!fim) {
			
			// Imprime o menu 
			System.out.print(menu);
			
			if(atual == "") {
				System.out.println(">>> Tarefa atual: <nenhuma> <<<");
			}
			else {
				System.out.println(">>> Tarefa atual:"+ atual + "<<<");
			}
			
			
			System.out.print("Escolha uma opção: ");
			// Caso o valor de entrada nao seja um inteiro o programa continuara rodando 
			try{ 
				escolha = input.nextInt();
			}catch(InputMismatchException e) {
				escolha = 8; // no switch case a escolha vai para default
				input.nextLine();
			}
			
			// Switch case para verificar a escolha do usuario
			switch (escolha){
			
			case 1:
				if(f1.IsEmpty() == true) {
					System.out.println("*** Não há tarefas na fila!");
					atual = "";
				}
				else {
					atual = f1.front();
					System.out.println(">>> Iniciando a tarefa: \n" + f1.front());
					f1.dequeue();
				}
				break;
								
			case 2:
				if(f1.IsFull() == true) {
					System.out.println("*** A fila de tarefas está cheia!");
				}
				else {
					System.out.println(">>> Descreva a nova tarefa: ");
					input.nextLine();
					nTarefa = input.nextLine();
					f1.enqueue(nTarefa);
				}
				break;
				
			case 3:
				System.out.println(">>> A próxima tarefa na fila é:");
				if(f1.IsEmpty() == true) {
					System.out.println("*** Não há tarefas na fila!\n");
				}
				else {
					System.out.println(f1.front() + "\n");
				}
				break;
				
			case 4:
				System.out.println(">>> Tarefas a fazer: "+ f1.Count() + " (de um máximo de "+ f1.size() + ").");
				break;
				
			case 5:
				f1.Clear();
				System.out.println(">>> Todas as tarefas foram removidas da fila!");
				atual = "";
				break;
				
			case 6:
				fim = true;
				break;
				
			default:
				System.out.println("*** Opção inválida!");
				break;
				
			}
		}
	}
}
