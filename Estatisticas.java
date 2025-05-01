package hospitalzinho;
public class Estatisticas {
	private int[] pacientesTriados;
    private int[] pacientesAtendidos;
    private int[] somaDosTemposDeEspera;
    private int pacientesEmObservacao;
    private int pacientesDesistentes;

    public Estatisticas() {
    	
    	pacientesAtendidos = new int[5];
        pacientesTriados = new int[5];
        somaDosTemposDeEspera = new int[5];
        pacientesEmObservacao = 0;
        pacientesDesistentes = 0;
    }

    //registra um paciente triado
    public void registrarTriagem(int prioridade) {
        pacientesTriados[prioridade - 1]++;
    }

    //registra paciente atendido
    public void registrarAtendimento(int prioridade, int tempoEspera) {
        pacientesAtendidos[prioridade - 1]++;
        somaDosTemposDeEspera[prioridade - 1] += tempoEspera;
    }

    //registra um paciente em observação
    public void registrarObservacao() {
        pacientesEmObservacao++;
    }

    //registra a desistencia de um paciente
    public void registrarDesistencia() {
        pacientesDesistentes++;
    }

    //método pra gerar um relatório
    public void gerarRelatorio() {
        System.out.println("------ RELATÓRIO ------");

        System.out.println("\nTotal de pacientes atendidos (em ordem de prioridade):");
        for (int i = 0; i < 5; i++) {
            System.out.println("Prioridade " + (i + 1) + ":  foram realizados " + pacientesAtendidos[i] + " atendimentos.");
        }

        System.out.println("\nTempo médio de espera por prioridade:");
        for (int i = 0; i < 5; i++) {
            if (pacientesAtendidos[i] > 0) {
                float media = (float) somaDosTemposDeEspera[i] / pacientesAtendidos[i];
                System.out.printf("Prioridade %d: %.2f unidades de tempo.\n", (i + 1), media);
            } else {
                System.out.println("Prioridade " + (i + 1) + ": Não foi realizado nenhum atendimento.");
            }
        }

        System.out.println("Número de pacientes observados: " + pacientesEmObservacao);
        System.out.println("Número de pacientes que desistiram: " + pacientesDesistentes);
    }
}