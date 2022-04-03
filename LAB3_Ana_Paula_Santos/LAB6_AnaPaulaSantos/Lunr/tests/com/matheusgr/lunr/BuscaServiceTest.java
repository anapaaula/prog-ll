package com.matheusgr.lunr;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.matheusgr.lunr.busca.BuscaService;
import com.matheusgr.lunr.busca.BuscaSimples;
import com.matheusgr.lunr.documento.DocumentoController;
import com.matheusgr.lunr.documento.DocumentoDTO;
import com.matheusgr.lunr.documento.DocumentoService;

class BuscaServiceTest {
	
	private BuscaService controle;
	private String[] termos;
	private BuscaSimples busca;
	private DocumentoService documentoService;

	
	
	@BeforeEach
	void testBuscaService() {
		this.documentoService = new DocumentoService();
		DocumentoController documentoController = new DocumentoController(this.documentoService); 
		documentoController.adicionaDocumentoHtml("HTML_ID", "Teste\n com \n três \n linhas");
		documentoController.adicionaDocumentoJava("JAVA_ID", "Teste uma \n linha ");
		this.controle = new BuscaService(this.documentoService);
		this.termos = new String[1];
		this.termos[0] = "uma";
		this.busca = new BuscaSimples(this.termos);
	}

	@Test
	void testBusca() {
		var documentos = this.controle.busca(this.busca);
		assertEquals(documentos.length, 1);
		for (int i = 0 ; i < documentos.length; i++) {
			assertEquals(documentos[i].getId(),"JAVA_ID");
		}
	}

	@Test
	void testRecuperaHistorico() {
		DocumentoDTO[] documentos = this.controle.busca(this.busca);
		String[] ids = this.controle.recuperaHistorico(0).ids();
		for (int i = 0 ; i < documentos.length; i++) {
			assertEquals(documentos[i].getId(), ids[i]);
		}
		
	}

}
