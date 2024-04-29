public class fila {
	private static final int MAX = 4;
	
	// Variaveis
	private String dados[]; // vetor de Strings (fila)
	private int contador; 
	private int primeiro;
	private int ultimo;
	
	//construtor vazio
	public fila() {
		this(MAX);
	}
	
	// construtor com argumento
	public fila(int tamanho) {
		contador = 0;
		primeiro = 0;
		ultimo = 0;
		dados = new String[tamanho];
	}
	
	// Adicionar tarefa na fila
	public void enqueue(String valor) {
			dados[ultimo] = valor;
			ultimo = (ultimo + 1) % dados.length;
			++contador;
	}
	
	// Remover tarefa da fila
	public String dequeue() {
		String valor = dados[primeiro];
		// Liberar o espaço que foi removido
		dados[primeiro] = "\0";
		primeiro = (primeiro + 1) % dados.length;
		--contador;
		
		return valor;
		
	}
	
	// mostra o primeiro elemento da fila
	public String front() {
		return dados[primeiro];
	}
	
	// Retorna a capacidade da fila
	public int size() {
		return MAX;
	}
	
	// Verifica se a fila está cheia
	public boolean IsFull() {
		if(contador == MAX) {
			return true;
		}
		else {
			return false;
		}
	}
	
	// Verifica se a fila está vazia
	public boolean IsEmpty() {
		if (contador == 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	// retorna o número de elementos na fila
	public int Count() {
		return contador;
	}
	
	// Limpa a fila
	public void Clear() {
		dados = new String[MAX];
	}
}
