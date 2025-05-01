package hospitalzinho;
public class ListaMedicos {
	//Atributos
	private NodoMedico iniciarMedico;

	//adiciona um medico na lista de medicos
    public void adicionar(Medico medico) {
        NodoMedico nodo = new NodoMedico(medico);
        if (iniciarMedico == null) {
            iniciarMedico = nodo;
        } else {
        	NodoMedico atual = iniciarMedico;
            while (atual.getProximo() != null) {
                atual = atual.getProximo();
            }
            atual.setProximo(nodo);
        }
    }
    
    //busca um medico pelo nome
    public Medico buscarPorNome(String nome) {
    	NodoMedico atual = iniciarMedico;
        while (atual != null) {
            if (atual.getMedico().getNome().equalsIgnoreCase(nome)) {
                return atual.getMedico();
            }
            atual = atual.getProximo();
        }
        return null;
    }
    
    //lista todos os médicos 
    public void listarMedicos() {
    	NodoMedico atual = iniciarMedico;
        if (atual == null) {
            System.out.println("Nenhum médico foi cadastrado até o momento");
            return;
        }
        while (atual != null) {
            atual.getMedico().imprimirInformacao();
            atual = atual.getProximo();
        }
    }
    
    
    //remove um medico da lista de medicos pelo nome
    public boolean remover(String nome) {
        if (iniciarMedico == null) {
        	return false;
        } else {
	        if (iniciarMedico.getMedico().getNome().equalsIgnoreCase(nome)) {
	            iniciarMedico = iniciarMedico.getProximo();
	            return true;
	        } else {
	        	NodoMedico atual = iniciarMedico;
		        while (atual.getProximo() != null) {
		            if (atual.getProximo().getMedico().getNome().equalsIgnoreCase(nome)) {
		                atual.setProximo(atual.getProximo().getProximo());
		                return true;
		            }
		            atual = atual.getProximo();
		        }
		        return false;
	        }
        }
    }



}