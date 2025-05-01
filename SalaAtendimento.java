package hospitalzinho;
public class SalaAtendimento {
	private int id;
    private Medico medico;
    private Paciente pacienteAtual;

    public SalaAtendimento(int id, Medico medico) {
        this.id = id;
        this.medico = medico;
        this.pacienteAtual = null;
    }
    
    public int getId() {
		return id;
	}
    
    public Medico getMedico() {
		return medico;
	}

    public Paciente getPacienteAtual() {
		return pacienteAtual;
	}
    
	//atendimento de pacientes
    public void atenderPaciente(Paciente paciente) {
    	if (isFree()) {
    		this.pacienteAtual = paciente;    		
    	}
    }

    //finaliza atendimento
    public Paciente finalizarAtendimento() {
        if (pacienteAtual != null) {
            Paciente atendido = pacienteAtual;
            pacienteAtual = null;
            return atendido;
        }
        return null;
    }

    //Método para verificar se esta livre
    public boolean isFree() {
        return pacienteAtual == null;
    }
}