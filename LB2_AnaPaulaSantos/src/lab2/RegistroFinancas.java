package lab2;
/**
 * 
 * Registra as finanças do estudante durante o curso. Podendo adicionar os ganhos e as 
 * despesas em centavos, e verificar como está a situação das finanças.
 * @author Ana Paula
 *
 */
public class RegistroFinancas {
	
	  private int[] ganhos;
	    private int ganhosIniciais;
	    private int despesasTotais;
	    private String[] descricaoDespesa = new String[5];
	    private int contador;
	    private String listaDetalhes = "";
/**
* O construtor recebe os ganhos iniciais e o total de ganhos. 
* Que respectivamente significam:
* @param ganhosIniciais um valor que o aluno já possui guardado e deseja cadastrar 
* @param totalDeGanhos é a quantidade de ganhos que o aluno vai receber 
*/
	    RegistroFinancas(int ganhosIniciais, int totalDeGanhos) {
	        this.ganhosIniciais = ganhosIniciais;
	        this.ganhos = new int[totalDeGanhos];
	    }
	    
/**
* Adiciona os ganhos do aluno em centavos e por posição.
* 
* @param valorCentavos valor dos ganhos que será adicionado em centavos
* @param posicaoGanho posição que o valor será cadastrado 
*/
	    public void adicionaGanhos(int valorCentavos, int posicaoGanho) {
	        this.ganhos[posicaoGanho - 1] = valorCentavos;

	    }
/**
* Recebe as despesas do aluno em centavos.
* 
* @param valorCentavos valor da despesa do aluno em centavos
*/
	    public void pagaDespesa(int valorCentavos) {
	        this.despesasTotais += valorCentavos;
	        this.descricaoDespesa[this.contador] = String.format("%d", valorCentavos);
	        this.contador +=1;

	    }
	    
/**
 * Exibe os ganhos cadastrados pelo aluno, até o momento.
 * 
 * @return uma string com os valores em centavos adicionados pelo aluno e suas posições  
 */
	    public String exibeGanhos() {
	        String mensagem = "";
	        for (int i = 0; i < this.ganhos.length; i++) {
	            if (i == this.ganhos.length - 1) {
	                mensagem += String.format("%s - %s", i + 1, this.ganhos[i]);
	            } else {
	                mensagem += String.format("%s - %s\n", i + 1, this.ganhos[i]);
	            }
	        }
	        return mensagem;
	    }
	    
	    
	    public void pagaDespesa(int valorCentavos, String detalhes) {
	        this.despesasTotais += valorCentavos;
	        this.descricaoDespesa[this.contador] = String.format("%d %s", valorCentavos, detalhes);
	        this.contador += 1;
	    }


	    public String listarDetalhes() {
	        for (int i = 0; i < this.descricaoDespesa.length; i++) {
	            if (this.descricaoDespesa[i] != null) {
	                this.listaDetalhes += String.format("%d - %s\n", i + 1, descricaoDespesa[i]);
	            }
	        }

	        return this.listaDetalhes;
	    }
/**
 * @return uma string com o valor total que o aluno recebeu junto com o ganho inicial, as despesas acumuladas 
 * e o total liquido disponivel   
 */
	    public String toString () {
            int totalRecebido = this.ganhosIniciais;
            int totalDisponivel;

            for (int ganho : this.ganhos) {
                totalRecebido += ganho;
            }
            totalDisponivel = totalRecebido - this.despesasTotais;
            return String.format("Total recebidos: %s, Despesas totais: %s, Total disponível: %s", totalRecebido, this.despesasTotais, totalDisponivel);

        }
    }


