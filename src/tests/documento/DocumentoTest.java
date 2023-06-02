package tests.documento;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import documento.Documento;
import elemento.Lista;
import elemento.Termos;
import elemento.Texto;
import elemento.Titulo;

class DocumentoTest {
	private Documento documento;
	
	@BeforeEach
	void prepareDocumento() {
		documento = new Documento("Titulo");
	}
	
	@Test
	void getQtdeElementosTest() {
		assertEquals(0, documento.getQtdeElementos());
		documento.addTexto("Valor", 1);
		assertEquals(1, documento.getQtdeElementos());
	}
	
	@Test
	void getDocumentoTest() {
		documento.addTexto("Valor", 1);
		assertEquals("Valor", documento.getDocumento()[0]);
	}
	
	@Test
	void addTextoTest() {
		assertEquals(1,documento.addTexto("Valor", 1));
	}
	
	@Test
	void addTituloTest() {
		assertEquals(1,documento.addTitulo("Valor", 1, 1, true));
	}
	
	@Test
	void addListaTest() {
		assertEquals(1,documento.addLista("Valor", 1, "/", "-"));
	}
	
	@Test
	void addTermosTest() {
		assertEquals(1,documento.addTermos("Valor", 1, "/", "NENHUM"));
	}
	
	@Test
	void getRepresentacaoCompletaTextoTest() {
		documento.addTexto("Valor", 1);
		
		Texto textoComparado = new Texto(1, "Valor");
		
		assertTrue(textoComparado.exibirCompleto().equals(documento.getElemento(1).exibirCompleto()));
	}
	
	@Test
	void getRepresentacaoResumidaTextoTest() {
		documento.addTexto("Valor", 1);
		
		Texto textoComparado = new Texto(1, "Valor");
		
		assertTrue(textoComparado.exibirResumido().equals(documento.getElemento(1).exibirResumido()));
	}
	
	@Test
	void getRepresentacaoCompletaTituloTest() {
		documento.addTitulo("Valor", 1, 1, true);

		HashMap<String, String> propriedadesTitulo = new HashMap<>();
		propriedadesTitulo.put("nivel", "1");
		propriedadesTitulo.put("linkavel", "true");
		
		Titulo tituloComparado = new Titulo(1, "Valor", propriedadesTitulo);

		assertTrue(tituloComparado.exibirCompleto().equals(documento.getElemento(1).exibirCompleto()));
	}
	
	@Test
	void getRepresentacaoResumidaTituloTest() {
		documento.addTitulo("Valor", 1, 1, true);

		HashMap<String, String> propriedadesTitulo = new HashMap<>();
		propriedadesTitulo.put("nivel", "1");
		propriedadesTitulo.put("linkável", "true");
		
		Titulo tituloComparado = new Titulo(1, "Valor", propriedadesTitulo);

		assertTrue(tituloComparado.exibirResumido().equals(documento.getElemento(1).exibirResumido()));
	}
	
	@Test
	void getRepresentacaoCompletaListaTest() {
		documento.addLista("Valor", 1, "/", "-");

		HashMap<String, String> propriedadesLista = new HashMap<>();
		propriedadesLista.put("separador", "/");
		propriedadesLista.put("charLista", "-");
		
		Lista listaComparado = new Lista(1, "Valor", propriedadesLista);

		assertTrue(listaComparado.exibirCompleto().equals(documento.getElemento(1).exibirCompleto()));
	}
	
	@Test
	void getRepresentacaoResumidaListaTest() {
		documento.addLista("Valor", 1, "/", "-");

		HashMap<String, String> propriedadesLista = new HashMap<>();
		propriedadesLista.put("separador", "/");
		propriedadesLista.put("charLista", "-");
		
		Lista listaComparado = new Lista(1, "Valor", propriedadesLista);

		assertTrue(listaComparado.exibirResumido().equals(documento.getElemento(1).exibirResumido()));
	}
	
	@Test
	void getRepresentacaoCompletaTermosNenhumaOrdenacaoTest() {
		
	}
	
	@Test
	void getRepresentacaoResumidaTermosNenhumaOrdenacaoTest() {
		
	}
	
	@Test
	void getRepresentacaoCompletaTermosOrdemAlfabeticaTest() {
		
	}
	
	@Test
	void getRepresentacaoResumidaTermosOrdemAlfabeticaTest() {
		
	}
	
	@Test
	void getRepresentacaoCompletaTermosOrdemTamanhoTest() {
		
	}
	
	@Test
	void getRepresentacaoResumidaTermosOrdemTamanhoTest() {
		
	}
	
	@Test
	void elevaElementoTest() {
		documento.addTexto("Valor1", 1);
		documento.addTexto("Valor2", 2);
		
		Texto textoComparado1 = new Texto(1, "Valor1");
		Texto textoComparado2 = new Texto(2, "Valor2");

		assertTrue(textoComparado1.exibirResumido().equals(documento.getElemento(1).exibirResumido()));
		assertTrue(textoComparado2.exibirResumido().equals(documento.getElemento(2).exibirResumido()));
		
		documento.elevaElemento(2);
		
		assertTrue(textoComparado1.exibirResumido().equals(documento.getElemento(2).exibirResumido()));
		assertTrue(textoComparado2.exibirResumido().equals(documento.getElemento(1).exibirResumido()));
	}
	
	@Test
	void cedeElementoTest() {
		documento.addTexto("Valor1", 1);
		documento.addTexto("Valor2", 2);
		
		Texto textoComparado1 = new Texto(1, "Valor1");
		Texto textoComparado2 = new Texto(2, "Valor2");

		assertTrue(textoComparado1.exibirResumido().equals(documento.getElemento(1).exibirResumido()));
		assertTrue(textoComparado2.exibirResumido().equals(documento.getElemento(2).exibirResumido()));
		
		documento.cedeElemento(1);
		
		assertTrue(textoComparado1.exibirResumido().equals(documento.getElemento(2).exibirResumido()));
		assertTrue(textoComparado2.exibirResumido().equals(documento.getElemento(1).exibirResumido()));
	}
	
	@Test
	void getElementoTest() {
		documento.addTexto("Valor", 1);
		documento.addTitulo("Valor", 1, 1, true);
		documento.addLista("Valor", 1, "/", "-");
		documento.addTermos("Valor", 1, "/", "NENHUM");
		
		Texto textoComparado = new Texto(1, "Valor");
		
		HashMap<String, String> propriedadesTitulo = new HashMap<>();
		propriedadesTitulo.put("nivel", "1");
		propriedadesTitulo.put("linkável", "true");
		
		Titulo tituloComparado = new Titulo(1, "Valor", propriedadesTitulo);
		
		HashMap<String, String> propriedadesLista = new HashMap<>();
		propriedadesLista.put("separador", "/");
		propriedadesLista.put("charLista", "-");
		
		Lista listaComparado = new Lista(1, "Valor", propriedadesLista);
		
		HashMap<String, String> propriedadesTermo = new HashMap<>();
		propriedadesTermo.put("separador", "/");
		propriedadesTermo.put("ordem", "NENHUM");
		
		Termos termoComparado = new Termos(1, "Valor", propriedadesTermo);
		
		assertTrue(textoComparado.exibirResumido().equals(documento.getElemento(1).exibirResumido()));
		assertTrue(tituloComparado.exibirResumido().equals(documento.getElemento(2).exibirResumido()));
		assertTrue(listaComparado.exibirResumido().equals(documento.getElemento(3).exibirResumido()));
		assertTrue(termoComparado.exibirResumido().equals(documento.getElemento(4).exibirResumido()));
	}
	
	@Test
	void getElementosTest() {
		documento.addTexto("Valor", 1);
		documento.addTitulo("Valor", 1, 1, true);
		documento.addLista("Valor", 1, "/", "-");
		documento.addTermos("Valor", 1, "/", "NENHUM");
		
		Texto textoComparado = new Texto(1, "Valor");
		
		HashMap<String, String> propriedadesTitulo = new HashMap<>();
		propriedadesTitulo.put("nivel", "1");
		propriedadesTitulo.put("linkável", "true");
		
		Titulo tituloComparado = new Titulo(1, "Valor", propriedadesTitulo);
		
		HashMap<String, String> propriedadesLista = new HashMap<>();
		propriedadesLista.put("separador", "/");
		propriedadesLista.put("charLista", "-");
		
		Lista listaComparado = new Lista(1, "Valor", propriedadesLista);
		
		HashMap<String, String> propriedadesTermo = new HashMap<>();
		propriedadesTermo.put("separador", "/");
		propriedadesTermo.put("ordem", "NENHUM");
		
		Termos termoComparado = new Termos(1, "Valor", propriedadesTermo);
		
		assertTrue(textoComparado.exibirResumido().equals(documento.getElementos().get(0).exibirResumido()));
		assertTrue(tituloComparado.exibirResumido().equals(documento.getElementos().get(1).exibirResumido()));
		assertTrue(listaComparado.exibirResumido().equals(documento.getElementos().get(2).exibirResumido()));
		assertTrue(termoComparado.exibirResumido().equals(documento.getElementos().get(3).exibirResumido()));
	}
	
	@Test
	void removeElementoTest() {
		documento.addTexto("Valor", 1);
		
		documento.removeElemento(1);
		try {
			documento.getElemento(1);
			fail("Não deveria encontrar um documento que foi apagado");
		} catch (IndexOutOfBoundsException iobe) {
			assertEquals("Posição inválida", iobe.getMessage());
		}
		
		documento.addTexto("Valor1", 1);
		documento.addTexto("Valor2", 2);
		
		Texto textoComparado = new Texto(2, "Valor2");
		
		documento.removeElemento(1);
		assertTrue(textoComparado.exibirResumido().equals(documento.getElemento(1).exibirResumido()));
	}
	
	@Test
	void addAtalhoTest() {
		
	}
}
