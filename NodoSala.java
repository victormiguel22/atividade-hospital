package hospitalzinho;
public class NodoSala {
	private SalaAtendimento sala;
    private NodoSala proximo;

    public NodoSala(SalaAtendimento sala) {
        this.sala = sala;
        this.proximo = null;
    }

	public SalaAtendimento getSala() {
		return sala;
	}

	public void setSala(SalaAtendimento sala) {
		this.sala = sala;
	}

	public NodoSala getProximo() {
		return proximo;
	}

	public void setProximo(NodoSala proximo) {
		this.proximo = proximo;
	}
}
