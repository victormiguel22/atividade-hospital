package hospitalzinho;
import java.util.Scanner;
public class Mainzinho {
	//constantes para o cálculo de tempo
	static int unidadeTempo = 1;
    static int MINUTOS = 15;
    
    public static void main(String[] args) {
    	
    	Scanner scanner = new Scanner(System.in); 
    	
    	int opcao;
    	
        Triagem triagem = new Triagem();


        
        //criar 5 objetos de médicos
        Medico patricia = triagem.inserirMedico("Dra. Patricia");
        Medico rafael = triagem.inserirMedico("Dr. Rafael");
        Medico pedro = triagem.inserirMedico("Dr. Pedro");
        Medico rodolfo = triagem.inserirMedico("Dr. Rodolfo");
        Medico sara = triagem.inserirMedico("Dra. Sara");
        
        //insere os mpédicos
        triagem.adicionarMedico("Dra. Patricia", "Clínica Geral", "08:00 - 16:00");
        triagem.adicionarMedico("Dr. Rafael", "Cirurgião", "11:00 - 17:00");
        triagem.adicionarMedico("Dr. Pedro", "Nefrologista", "09:00 - 17:00");
        triagem.adicionarMedico("Dr. Rodolfo", "Endocrinologista", "08:00 - 15:00");
        triagem.adicionarMedico("Dra. Sara", "Pediatra", "08:00 - 16:00");
        
        //criar as salas de atendimento com os médicos
        triagem.adicionarSala(1, patricia);
        triagem.adicionarSala(2, rafael);
        triagem.adicionarSala(3, pedro);
        triagem.adicionarSala(4, rodolfo);
        triagem.adicionarSala(5, sara);

        //menu
        do {
        	System.out.println("\n===== Menu =====");
        	System.out.println("1 - Relatório");
        	System.out.println("2 - Buscar médico");
        	System.out.println("3 - Adiantar uma unidade de tempo (15 min)");
        	System.out.println("4 - Fechar Programa");
        	System.out.print("Escolha uma opção: ");
        	opcao = scanner.nextInt();
        	if (opcao == 1) {
        		triagem.gerarRelatorio();
        	} else if (opcao == 2) {
        		triagem.consultarMedicos();
        	} else if (opcao == 3) {
        		adiantarUnidadeTempo(triagem);
        	}
        } while (opcao != 4);
        
        System.out.println("------ Você fechou o programa ------");
        scanner.close();
    }
    
    public static void adiantarUnidadeTempo(Triagem triagem) {
        System.out.println("------ Unidade de Tempo " + unidadeTempo + " (" + MINUTOS + " minutos) ------");
	    triagem.simularUnidadeDeTempo();
	    unidadeTempo++;
	    MINUTOS+=15;
	    if (triagem.filasVazias() && triagem.salasLivres() && triagem.observacaoVazia()) {
	    	System.out.println("Não há ninguém na fila!");
	    }
	    
    	return;
    	
    }
}
