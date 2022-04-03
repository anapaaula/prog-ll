package uni;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.matheusgr.lunr.LunrApp;
import com.matheusgr.lunr.documento.DocumentoDTO;

public class MeuMain {
	public static void main(String[] args) {
		
		
		LunrApp j = new LunrApp();
		
		Map<String, String> metadados = new HashMap<>();
	
		
		metadados.put("LINHAS", "3");
		metadados.put("TIPO", "html");
		
	
		
		j.getDocumentoController().adicionaDocumentoHtml("html", "Teste\n com \n três \n linhas");
		j.getDocumentoController().adicionaDocumentoJava("JAVA", "Teste  com \n três \n linhas");
		j.getDocumentoController().adicionaDocumentoTxt("TXT", "Teste \n com \n três \n linhas");
		
		
		DocumentoDTO[] g = j.getBuscaController().busca(metadados);
		
	
		for(int i = 0; i < g.length; i++) {
			System.out.println(g[i].getMetadados());
		}
		
		
		String[][] consulta = j.getBuscaController().recuperaHistoricoDepuracao(0); 
		System.out.println(Arrays.deepToString(consulta));
		
	}
}


