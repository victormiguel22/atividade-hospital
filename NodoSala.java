package hospitalzinho;
public class NodoSala {
	//Atributos
	private SalaAtendimento sala;
    private NodoSala proximo;

    //Construtor
    public NodoSala(SalaAtendimento sala) {
        this.sala = sala;
        this.proximo = null;
    }

    //Getters e Setters do atributo sala
	public SalaAtendimento getSala() {
		return sala;
	}

	public void setSala(SalaAtendimento sala) {
		this.sala = sala;
	}

	//Getters e Setter do atributo proximo
	public NodoSala getProximo() {
		return proximo;
	}

	public void setProximo(NodoSala proximo) {
		this.proximo = proximo;
	}
}