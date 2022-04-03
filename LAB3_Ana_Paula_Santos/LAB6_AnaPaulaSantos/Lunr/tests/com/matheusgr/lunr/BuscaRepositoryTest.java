package com.matheusgr.lunr;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.matheusgr.lunr.busca.BuscaController;
import com.matheusgr.lunr.busca.BuscaRepository;
import com.matheusgr.lunr.busca.BuscaService;
import com.matheusgr.lunr.busca.BuscaSimples;
import com.matheusgr.lunr.documento.DocumentoController;
import com.matheusgr.lunr.documento.DocumentoService;

class BuscaRepositoryTest {
	
	BuscaController buscaController;
	BuscaRepository controle;
	String[] termos;
	BuscaSimples busca;
	
	@BeforeEach
	void testBuscaRepository() {
		this.buscaController = new BuscaController(new BuscaService(new DocumentoService()));
		this.termos = new String[2];
		this.termos[0] = "Teste";
		this.termos[1] = "com"; 
		DocumentoController documentoController = new DocumentoController(new DocumentoService()); 
		documentoController.adicionaDocumentoHtml("HTML_ID", "Teste\n com \n três \n linhas");
		documentoController.adicionaDocumentoJava("JAVA_ID", "Teste uma \n linha ");
		this.controle = new BuscaRepository();
		this.busca = new BuscaSimples(this.termos);
		
	}

	@Test
	void testAdicionaBuscaNoHistorico() {
		var documento = this.buscaController.busca(this.termos);
		this.controle.adicionaBuscaNoHistorico(this.busca, documento);
		String[][] historico = this.controle.recuperar(0).debug();
		String[][] resposta = {{"TERMO 1", "Teste"}, {"TERMO 2", "com"}};
		Assert.assertArrayEquals(historico, resposta);
		
	}

	@Test
	void testRecuperarNumeroInvalido() {
		var documento = this.buscaController.busca(this.termos);
		this.controle.adicionaBuscaNoHistorico(this.busca, documento);
		try {
			this.controle.recuperar(2);
			fail("indice inválido!");
		}catch(IllegalArgumentException iae) {
			
		}
	
		
	}
	

	@Test
	void testRecuperar() {
		var documento = this.buscaController.busca(this.termos);
		this.controle.adicionaBuscaNoHistorico(this.busca, documento);
		String[][] historico = this.controle.recuperar(0).debug();
		String[][] resposta = {{"TERMO 1", "Teste"}, {"TERMO 2", "com"}};
		Assert.assertArrayEquals(historico, resposta);
	}

}
