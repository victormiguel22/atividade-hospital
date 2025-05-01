package hospitalzinho;
public class ListaSalas {
	private NodoSala iniciarSalas;

	//adiciona uma sala na lista de salas
    public void adicionarSala(SalaAtendimento sala) {
    	NodoSala nodoSala = new NodoSala(sala);
        if (iniciarSalas == null) {
            iniciarSalas = nodoSala;
        } else {
        	NodoSala atual = iniciarSalas;
            while (atual.getProximo() != null) {
                atual = atual.getProximo();
            }
            atual.setProximo(nodoSala);
        }
    }
    
    public NodoSala getIniciarSalas() {
        return iniciarSalas;
    }
}