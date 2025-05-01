package hospitalzinho;
public class Paciente {
	private int id;
	private String sintomas;
	private String nome;
	private Paciente proximo;
	private int prioridade;
	private int tempoDeChegada;
	
	public Paciente(int id, String nome, String sintomas, int prioridade) {
		this.id = id;
		this.nome = nome;
		this.sintomas = sintomas;
		this.prioridade = prioridade;
		this.proximo = null;
	}
	
	public Paciente(Paciente paciente) {
		this.id = paciente.getId();
		this.nome = paciente.getNome();
		this.sintomas = paciente.getSintomas();
		this.prioridade = paciente.getPrioridade();
		this.proximo = paciente.getProximo();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getSintomas() {
		return sintomas;
	}

	public void setSintomas(String sintomas) {
		this.sintomas = sintomas;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Paciente getProximo() {
		return proximo;
	}

	public void setProximo(Paciente proximo) {
		this.proximo = proximo;
	}

	public int getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(int prioridade) {
		this.prioridade = prioridade;
	}
	
	public int getTempoDeChegada() {
	    return tempoDeChegada;
	}

	public void setTempoDeChegada(int tempoDeChegada) {
	    this.tempoDeChegada = tempoDeChegada;
	}
	
}