package hospitalzinho;
public class Fila {
	//Atributos
	private Paciente inicio;
	private Paciente fim;
	
	//Método para verificar se a fila esta vazia
	public boolean estaVazia() {
		return inicio == null;
	}
	
	//Método para adicionar no inicio da fila
	public void adicionarNaFila(Paciente novo) {
		if(estaVazia()) {
			inicio = fim = novo;
		} else {
			fim.setProximo(novo);
			fim = novo;
		}
	}
	
	//Método para remover do final da fila
	public Paciente tirarDaFila() {
		if(estaVazia()) {
			return null;
		} else {
			Paciente removido = inicio;
			inicio = inicio.getProximo();
			if(inicio == null) {
				fim = null;
			}
			return removido;
		}
	}
	
	//Método que verifica a desistência dos pacientes
	public void verificarDesistencia(int tempoAtual, int tempoMaximo, Estatisticas estatisticas) {
		Paciente anterior = null;
		Paciente atual = inicio;
        while (atual != null) {
            int tempoEspera = tempoAtual - atual.getTempoDeChegada();
            if (tempoEspera > tempoMaximo) {
                System.out.println("Paciente " + atual.getNome() + " desistiu após esperar " + tempoEspera + " unidades de tempo.");
                estatisticas.registrarDesistencia();
                
                if (anterior == null) { // Se é o primeiro da fila
                    inicio = atual.getProximo();
                    if (inicio == null) fim = null;
                    atual = inicio;
                } else {
                    anterior.setProximo(atual.getProximo());
                    if (atual == fim) fim = anterior;
                    atual = anterior.getProximo();
                }
            } else {
                anterior = atual;
                atual = atual.getProximo();
            }
        }
    }
	
	//Método para mostrar a fila
	public void mostrarFila() {
		Paciente atual = inicio;
        while (atual != null) {
            System.out.println("ID: " + atual.getId() + " | Nome: " + atual.getNome() + " | Prioridade: " + atual.getPrioridade());
            atual = atual.getProximo();
        }
	}
}