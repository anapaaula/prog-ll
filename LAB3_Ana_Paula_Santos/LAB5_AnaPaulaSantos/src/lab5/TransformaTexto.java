package lab5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
/**
 * A BibliTeX permite que um texto seja transformado através de operações textuais específicas, 
 * armazena um histórico das transformações realizadas, incluindo os textos originais. 
 * E também oferece tipos de serviços de log.
 * 
 * @author Ana Paula
 *
 */

public class TransformaTexto implements Logger{
	
	private Map<String, AlgoritmoTransformacao> transformaTextos;
	private List<String> historico;
	private int contaTransformacao;
	private Logger log = null;
	
	
	/**
	 * Inicializa o TransformaTexto com o serviço de algum tipo de log.
	 * 
	 * @param log uma classe Logger
	 */
	public TransformaTexto(Logger log) {
		if(log == null) {
			throw new NullPointerException("Logger nulo");
		}
		this.log = log;
		this.transformaTextos = new TreeMap<>();
		this.historico = new ArrayList<>(); 
		this.transformaTextos.put("CaMeLcAsEfY", new CaMeLcAsEfY());
		this.transformaTextos.put("clean", new Clean());
		this.transformaTextos.put("InterrogaPraPontos", new ConverteInterrogacoesParaPontos());
		this.transformaTextos.put("upperCase", new UpperCase());
		this.transformaTextos.put("cleanSpaces", new CleanSpaces());
		this.transformaTextos.put("TrocarTodosOsAsParaE", new TrocarTodosOsAsParaE());
		
	}
	
	/**
	 * Inicializa o TransformaTexto sem passar parametros.
	 * 
	 */
	public TransformaTexto() {
		this.transformaTextos = new TreeMap<>();
		this.historico = new ArrayList<>(); 
		this.transformaTextos.put("CaMeLcAsEfY", new CaMeLcAsEfY());
		this.transformaTextos.put("clean", new Clean());
		this.transformaTextos.put("InterrogaPraPontos", new ConverteInterrogacoesParaPontos());
		this.transformaTextos.put("upperCase", new UpperCase());
		this.transformaTextos.put("cleanSpaces", new CleanSpaces());
		this.transformaTextos.put("TrocarTodosOsAsParaE", new TrocarTodosOsAsParaE());
		
	}

	
	/**
	 * Cadastra uma transformação criada pelo usuario da BibliTeX.
	 * 
	 * @param nome da transformação
	 * @param algoritmo do tipo geral AlgoritmoTransformacao
	 */
	public void cadastraTransformacao(String nome, AlgoritmoTransformacao algoritmo) {
		logger("cadastraTransformacao", nome);
		if (nome == null || algoritmo == null) {
			throw new NullPointerException("Operação inválida");
		}if (nome.isBlank()) {
			throw new IllegalArgumentException("Operação inválida");
		}
		this.transformaTextos.put(nome,algoritmo);
		
	}
	
	/**
	 * Recebe a string a ser transformada e delega o serviço para as classes 
	 * com a lógica para realizar essas operações, e retorna a frase transformada.
	 *  
	 * @param nome da transformação
	 * @param string2 que será transformada
	 * @return frase transformada
	 */
	public String transforma(String nome, String string2) {
		logger("transforma", nome);
		if (this.transformaTextos.get(nome) != null) {
			this.contaTransformacao +=1;
			String strTransformada = this.transformaTextos.get(nome).transforma(string2);
			this.historico.add(string2 + " - " + nome + " -> " + strTransformada);
			return strTransformada;}
		throw new IllegalArgumentException("Transformação não existe!");
			
	
	}
	
	/**
	 * Conta quantas transformações foram realizadas pela BibliTeX.
	 * 
	 * @return um inteiro da quantidade de transformações feitas 
	 */
	public int contaTransformacao() {
		logger("contaTransformacao");
		return this.contaTransformacao;
	}
	
	
	/**
	 * Mostra uma transformação específica de acordo com o indice.
	 * 
	 * @param indice de quando a transformação foi invocada
	 * @return a string original, a string transformada e o nome da transformação realizada
	 */
	public String historico(int indice) {
		logger("historico", Integer.toString(indice));
		return this.historico.get(indice);
	}
	
	
	/**
	 * Lista as strings originais que foram trasformadas, sem repetições.
	 * 
	 * @return strings originais que foram modificadas pela BibliTeX
	 */
	public String listarOriginais() {
		logger("listarOriginais");
		Set<String> listaSemRepeticoes = new HashSet<>();
		List<String> lista = new ArrayList<>();
		
	    for (String str : this.historico) {
	        String[] listStr = str.split(" - ");
	        listaSemRepeticoes.add(listStr[0]);
	      
	    } 
	    lista.addAll(listaSemRepeticoes);
	    
	    String listaOriginais = "";
	    for (String i : lista) {
	            listaOriginais += i + "\n";
	        }
	       
		return listaOriginais;

	}
	
	/**
	 * Lista as transformações existentes. 
	 * 
	 * @return nome das transformações por ordem alfabética 
	 */
	public String listarTransformacoes() {
		logger("listarTransformacoes");
			 List<String> listaTransformacoes = ordenarListaPeloGetNome();
			 String lista = "";
			  for (String transformacoes : listaTransformacoes) {
					lista += transformacoes + "\n";
				    }
			  return lista;
	}
	
	
	/**
	 * Ordena uma lista por ordem alfabética.
	 * 
	 * @return lista ordenada por ordem alfabética.
	 */
	public List<String> ordenarListaPeloGetNome() {
		logger("ordenarListaPeloGetNome");
		ArrayList<String> listaTransformacoes = new ArrayList<>();
		for (AlgoritmoTransformacao transformacao : this.transformaTextos.values()) {
			if (transformacao.getNome() != null)
				listaTransformacoes.add(transformacao.getNome());
			 }
			Collections.sort(listaTransformacoes);
			return listaTransformacoes;
	    
	}
	
	/**
	 * Recebe o nome e o primeiro parametro do método invocado na classe TrasformaTexto, 
	 * e delega os serviços para classe Logger.
	 */
	@Override
	public void logger(String metodo, String parametro) {
		if (log != null) {this.log.logger(metodo, parametro);}
		
	}
	
	/**
	 * Recebe o nome do método invocado na classe TrasformaTexto, 
	 * e delega os serviços para classe Logger.
	 */
	@Override
	public void logger(String metodo) {
		if (log != null) {this.log.logger(metodo);}
		
	}

	
}

	
	


	
	
	
