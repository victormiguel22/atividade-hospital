package hospitalzinho;
public class PacienteObs {
    private Paciente paciente;
    private int tempoRestante;
    private PacienteObs proximo;
    
    public PacienteObs(Paciente paciente, int tempoObservacao) {
        this.paciente = paciente;
        this.tempoRestante = tempoObservacao;
        this.proximo = null;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public int getTempoRestante() {
        return tempoRestante;
    }

    public PacienteObs getProximo() {
		return proximo;
	}

	public void setProximo(PacienteObs proximo) {
		this.proximo = proximo;
	}
	
    //sinaliza que o paciente está livre pra ser atendido
    public boolean estaProntoParaAlta() {
        return tempoRestante <= 0;
    }
    
	//reduz o tempo restante de observação do paciente
    public void reduzirTempo() {
        tempoRestante--;
    }


}
