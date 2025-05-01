package hospitalzinho;
public class NodoMedico {
	//Atributos
	private Medico medico;
    private NodoMedico proximo;

    //Construtor
    public NodoMedico(Medico medico) {
        this.medico = medico;
        this.proximo = null;
    }

    //Getters e Setters do atributo medico
	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	//Getters e Setters do atributo proximo
	public NodoMedico getProximo() {
		return proximo;
	}

	public void setProximo(NodoMedico proximo) {
		this.proximo = proximo;
	}
}