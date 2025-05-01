package hospitalzinho;
public class Medico {
	private String nome;
	private String especialidade;
    private String escala;

    public Medico(String nome, String especialidade, String escala) {
        this.escala = escala;
        this.nome = nome;
        this.especialidade = especialidade;
        
    }
    
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}


	public String getEscala() {
		return escala;
	}

	public void setEscala(String escala) {
		this.escala = escala;
	}

	//imprime as informaçoes do médico no relatório
	public void imprimirInformacao() {
        System.out.println("Nome: " + nome + "  Especialidade: " + especialidade + " | Escala: " + escala);
    }
}