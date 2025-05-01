package hospitalzinho;
import java.util.Random;
public class Triagem {
	//Atributos
	private Fila[] filas;
	private int idContador = 1;
	private static final int MAX_SALAS = 5;
	private ListaSalas salas;
	private ListaMedicos medicos;
    private int totalSalas = 0;
    private PilhaObservacao observacao = new PilhaObservacao();
    private Estatisticas estatisticas;
    private int tempoAtual = 0;
    private static final int TEMPOMAXIMODEESPERA = 6;
    private Random random = new Random();
    
	public Triagem() {
		this.filas = new Fila[5];
		for (int i = 0; i < 5; i++) {
            filas[i] = new Fila();
        }
		salas = new ListaSalas();
		medicos = new ListaMedicos();
		estatisticas = new Estatisticas();
	}
	
	//adiciona medico
	public void adicionarMedico(String nome, String especialidade, String escala) {
        Medico novo = new Medico(nome, especialidade, escala);
        medicos.adicionar(novo);
        //System.out.println("Médico cadastrado com sucesso!");
    }
	
	//remove medico
	public void removerMedico(String nome) {
        boolean removido = medicos.remover(nome);
        if (removido) {
            System.out.println("Médico removido com sucesso!");
        } else {
            System.out.println("Médico não encontrado.");
        }
    }
	
	//aloca os médicos nas salas disponíveis
		public void alocarMedicoSala(String nomeMedico, int idSala) {
	        Medico medico = medicos.buscarPorNome(nomeMedico);
	        if (medico == null) {
	            System.out.println("\nMédico não encontrado.");
	            return;
	        }
	        NodoSala atual = salas.getIniciarSalas();
	        while (atual != null) {
	            if (atual.getSala().getId() == idSala) {
	                atual.setSala(new SalaAtendimento(idSala, medico));
	                System.out.println("Médico " + nomeMedico + " alocado à sala " + idSala + " com sucesso.");
	                return;
	            }
	            atual = atual.getProximo();
	        }
	        System.out.println("Sala " + idSala + " não encontrada.");
	    }
	
	//lista todos os medicos
	public void consultarMedicos() {
		System.out.println("");
        medicos.listarMedicos();
    }
	
	//pesquisa os médicos por nome
	public Medico inserirMedico(String nome) {
	    return medicos.buscarPorNome(nome);
	}
	
	//adiciona uma sala disponível com um médico atribuido
	public void adicionarSala(int id, Medico medico) {
        if (totalSalas >= MAX_SALAS) {
            return;
        }
        salas.adicionarSala(new SalaAtendimento(id, medico));
        totalSalas++;
    }
	
	
	//busca o próximo paciente na fila
	private Paciente buscarProximoPaciente() {
        for (int i = 0; i < 5; i++) {
            if (!filas[i].estaVazia()) {
                return filas[i].tirarDaFila();
            }
        }
        return null;
    }
	
	//adiciona um paciente para ser triado
	public void adicionarPaciente(String nome, String sintomas, int prioridade) {
        if (prioridade < 1 || prioridade > 5) {
            System.out.println("Valor Inválido. As prioridades vão de 1 a 5.");
            return;
        } else {
        	Paciente novo = new Paciente(idContador++, nome, sintomas, prioridade);
        	novo.setTempoDeChegada(tempoAtual);
        	filas[prioridade - 1].adicionarNaFila(novo);
        	estatisticas.registrarTriagem(novo.getPrioridade());      	
        }
    }
	
	//mostra as filas de prioridades individualmente
	public void imprimirFilas() {
        for (int i = 0; i < 5; i++) {
            System.out.println("\nFila de Prioridade " + (i + 1) + ":");
            filas[i].mostrarFila();
        }
    }


	
	//simula uma unidade de tempo
	public void simularUnidadeDeTempo() {
		int novosPacientes = random.nextInt(4);
		if (novosPacientes > 0) {
			System.out.println("\n===== Paciente Novos =====");
		}
		for (int i = 0; i < novosPacientes; i++) {
			String[] nomes = {
				    "Aline", "Breno", "Cintia", "Diego", "Elisa", "Felipe", "Giovana", "Hugo",
				    "Isabela", "Jonas", "Karina", "Leandro", "Mirela", "Nicolas", "Olívia", "Pedro",
				    "Renata", "Sandro", "Talita", "Vitor"
				};

			String[] sobrenomes = {
				    "Andrade", "Borges", "Camargo", "Duarte", "Esteves", "Farias", "Garcia", "Henrique",
				    "Ibrahim", "Jardim", "Klein", "Leal", "Macedo", "Neves", "Ortega", "Pinto",
				    "Queiroz", "Rezende", "Siqueira", "Teixeira"
				};
			String nome = nomes[random.nextInt(nomes.length)] + " " + sobrenomes[random.nextInt(sobrenomes.length)];
	        String sintomas = gerarSintomasAleatorios();
	        int prioridade = random.nextInt(5) + 1;
	        adicionarPaciente(nome, sintomas, prioridade);
	        System.out.println("Novo paciente chegou: " + nome + " (" + sintomas + ") - Prioridade " + prioridade);
	    }
		verificarDesistencia();
	
		System.out.println("\n===== Status das Salas =====");
	    NodoSala atual = salas.getIniciarSalas();
	    while (atual != null) {
	        SalaAtendimento sala = atual.getSala();
	        if (sala.isFree()) {
	            System.out.println("Sala " + sala.getId() + " - Nenhum paciente para atender.");
	        } else {
	            Paciente pacienteParaAtender = sala.getPacienteAtual();
	            System.out.println("Sala " + sala.getId() + " - Dr(a). " + sala.getMedico().getNome() + " está atendendo o paciente: " + pacienteParaAtender.getNome() + " (Prioridade " + pacienteParaAtender.getPrioridade() + ")");
	        }
	        atual = atual.getProximo();
	    }
	    
	    //reset da variável pro novo percurso
	    atual = salas.getIniciarSalas();
	    while (atual != null) {
	        SalaAtendimento sala = atual.getSala();

	        if (sala.isFree()) {
	            Paciente pacienteParaAtender = buscarProximoPaciente();
	            if (pacienteParaAtender != null) {
	            	int tempoEspera = tempoAtual - pacienteParaAtender.getTempoDeChegada();
	                sala.atenderPaciente(pacienteParaAtender);
	                estatisticas.registrarAtendimento(pacienteParaAtender.getPrioridade(), tempoEspera);
	            }
	        } else {
	        	Paciente atendido = sala.finalizarAtendimento();
	        	
	            // Simula 50% de chance de observação
	        	if (atendido != null) {
		            if (atendido != null && Math.random() < 0.5) {
		            	System.out.println("Paciente " + atendido.getNome() + " foi atendido(a) e enviado(a) para observação por 3 unidades de tempo");
		                observacao.empilhar(atendido);
		                estatisticas.registrarObservacao();
		            } else {
		            	System.out.println("Paciente " + atendido.getNome() + " foi atendido(a) e liberado(a)");
		            }
	        	}
	        }

	        atual = atual.getProximo();
	    }
	    observacao.processarObs();
	    tempoAtual++;
    }
	
	//verifica a desistência dos pacientes
	public void verificarDesistencia() {
        for (int i = 0; i < 5; i++) {
            filas[i].verificarDesistencia(tempoAtual, TEMPOMAXIMODEESPERA, estatisticas);
        }
    }
	

	//verifica se todas as salas estão livres
	public boolean salasLivres() {
	    NodoSala atual = salas.getIniciarSalas();
	    while (atual != null) {
	        if (!atual.getSala().isFree()) {
	            return false;
	        }
	        atual = atual.getProximo();
	    }
	    return true;
	}	
	
	//verifica se as filas estão vazias
	public boolean filasVazias() {
	    for (int i = 0; i < 5; i++) {
	        if (!filas[i].estaVazia()) {
	            return false;
	        }
	    }
	    return true;
	}

	
		//gera relatorio de estatísticas
	public void gerarRelatorio() {
		estatisticas.gerarRelatorio();
	}
	
	//verifica se não existe pacientes em observação
	public boolean observacaoVazia() {
	    return observacao.isEmpty();
	}
	
	
	//escolhe sintoma aleatoriamente
	private String gerarSintomasAleatorios() {
	    String[] sintomasPossiveis = {
	        "Febre", "Náusea", "Respiração pesada",
	        "Corte superficial", "Dor de cabeça", "Vômito", "Dores", "Fratura", "Perda de equilíbrio"
	    };
	    return sintomasPossiveis[random.nextInt(sintomasPossiveis.length)];
	}
}
