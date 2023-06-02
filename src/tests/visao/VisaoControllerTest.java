package tests.visao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import documento.DocumentoController;
import visao.VisaoController;

class VisaoControllerTest {
	DocumentoController documentoController;
	VisaoController visaoController;
	
	@BeforeEach
	void prepareDocumentoEVisaoController() {
		this.documentoController = new DocumentoController();
		documentoController.addDocumento("Titulo");
		this.visaoController = new VisaoController();
		documentoController.getDocumento("Titulo").addTexto("Valor", 1);
		documentoController.getDocumento("Titulo").addTitulo("Valor", 1, 1, true);
		documentoController.getDocumento("Titulo").addLista("Valor", 1, "/", "-");
		documentoController.getDocumento("Titulo").addTermos("Valor", 1, "/", "NENHUM");
	}
	
	@Test
    void criarVisaoCompletaTest() {
    	assertEquals(1, visaoController.criarVisaoCompleta("Titulo", documentoController));
    }
    
	@Test
    void criaVisaoResumidaTest() {
		assertEquals(1, visaoController.criarVisaoResumida("Titulo", documentoController));  	
    }
    
	@Test
    void criarVisaoPrioritariaTest() {
		assertEquals(1, visaoController.criarVisaoPrioritaria("Titulo", 1, documentoController));
    }
    
	@Test
    void criarVisaoTituloTest() {
		assertEquals(1, visaoController.criarVisaoTitulo("Titulo", documentoController));
    }
    
	@Test
    void exibirVisaoTest() {
    	
    }
}