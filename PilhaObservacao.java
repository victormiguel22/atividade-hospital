package hospitalzinho;
public class PilhaObservacao {
    private PacienteObs topo;

    public PilhaObservacao() {
        topo = null;
    }

    //empilha um paciente novo
    public void empilhar(Paciente paciente) {
        PacienteObs novo = new PacienteObs(paciente, 3);
        novo.setProximo(topo);
        topo = novo;
    }

    //desempilha o último paciente que chegou
    public void processarObs() {
        if (topo == null) {
            System.out.println("Nenhum paciente em observação.");
            return;
        }
        PacienteObs atual = topo;
        PacienteObs anterior = null;
        while (atual != null) {
        	atual.reduzirTempo();
        	if (atual.estaProntoParaAlta()) {
        		 System.out.println("Paciente " + atual.getPaciente().getNome() + " recebeu alta da observação.");
        		 if (anterior == null) {
        			 topo = atual.getProximo();
        			 atual = topo;
        		 } else {
        			 anterior.setProximo(atual.getProximo());
        			 atual = anterior.getProximo();
        		 }
        	} else {
        		anterior = atual;
        		atual = atual.getProximo();
        	}
        }
    }

    public boolean isEmpty() {
        return topo == null;
    }

    //lista todos os pacientes em observacao
    public void listarObservacao() {
        System.out.println("------ Pacientes em Observação ------");
        PacienteObs atual = topo;
        while (atual != null) {
            System.out.println("Paciente " + atual.getPaciente().getNome() + " resta " + atual.getTempoRestante() + " unidade de tempo");
            atual = atual.getProximo();
        }
    }
}