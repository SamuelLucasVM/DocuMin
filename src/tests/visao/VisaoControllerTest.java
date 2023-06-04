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
		documentoController.getDocumento("Titulo").addLista("Valor/Separado", 1, "/", "-");
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
    void exibirVisaoIdInvalidoTest() {
		visaoController.criarVisaoCompleta("Titulo", documentoController);

		try {
			visaoController.exibirVisao(0);
			fail("Deveria quebrar ao passar um Id inválido");
		} catch (IndexOutOfBoundsException iobe) {
			assertEquals("Id inválido",iobe.getMessage());
		}
		
		try {
			visaoController.exibirVisao(2);
			fail("Deveria quebrar ao passar um Id inválido");
		} catch (IndexOutOfBoundsException iobe) {
			assertEquals("Id inválido",iobe.getMessage());
		}
    }
    
	@Test
    void exibirVisaoCompletaTest() {
		visaoController.criarVisaoCompleta("Titulo", documentoController);

		assertEquals("Valor", visaoController.exibirVisao(1)[0]);
		assertEquals("1. Valor -- VALOR", visaoController.exibirVisao(1)[1]);
		assertEquals("- Valor\n- Separado", visaoController.exibirVisao(1)[2]);
		assertEquals("Total de Termos: 1\n- Valor", visaoController.exibirVisao(1)[3]);
    }
    
	@Test
    void exibirVisaoResumidaTest() {
		visaoController.criarVisaoResumida("Titulo", documentoController);
		
		assertEquals("Valor", visaoController.exibirVisao(1)[0]);
		assertEquals("1. Valor", visaoController.exibirVisao(1)[1]);
		assertEquals("Valor/Separado", visaoController.exibirVisao(1)[2]);
		assertEquals("Valor", visaoController.exibirVisao(1)[3]);
    }
    
	@Test
    void exibirVisaoPrioritariaTest() {
		visaoController.criarVisaoPrioritaria("Titulo", 1, documentoController);

		for (String o : visaoController.exibirVisao(1)) {
			System.out.println(o);
		}
		
		assertEquals("Valor", visaoController.exibirVisao(1)[0]);
		assertEquals("1. Valor", visaoController.exibirVisao(1)[1]);
		assertEquals("Valor/Separado", visaoController.exibirVisao(1)[2]);
		assertEquals("Valor", visaoController.exibirVisao(1)[3]);
    }
    
	@Test
    void exibirVisaoTituloTest() {
		visaoController.criarVisaoTitulo("Titulo", documentoController);
		
		assertEquals("", visaoController.exibirVisao(1));
	}
	
}