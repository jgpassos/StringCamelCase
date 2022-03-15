package atividade_avaliativa_01;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;

class TestCadeiaDeCaracteres {

	private CadeiaDeCaracteres cc;
	private List<?> testeCC;

	@Before
	public void inicializaCadeiaDeCaracteres() {
		cc = new CadeiaDeCaracteres();
	}

	@SuppressWarnings("static-access")
	@Test
	void cadeiaValida() {
		assertFalse(cc.cadeiaValida(""));
		assertFalse(cc.cadeiaValida(" "));
		assertFalse(cc.cadeiaValida(null));
	}

	@SuppressWarnings("static-access")
	@Test
	void verificaSeHaCaracteresEspeciais() {
		assertTrue(cc.haCaracteresEspeciais("abcd?g"));
		assertFalse(cc.haCaracteresEspeciais("naoHaCaracteresEspeciais"));
	}

	@SuppressWarnings("static-access")
	@Test
	void verificaSeIniciaComNumeros() {
		assertTrue(cc.iniciaComNumeros("01testando"));
		assertFalse(cc.iniciaComNumeros("testando01teste"));
		assertFalse(cc.iniciaComNumeros("naoIniciaComNumeros"));
	}

	@Test
	void verificaConverterCamelCase() {

		// "nome" para "nome"
		testeCC = cc.converterCamelCase("nome");
		assertEquals(testeCC.size(), 1);
		assertEquals(testeCC.get(0), "nome");

		// "Nome" para "nome"
		testeCC = cc.converterCamelCase("Nome");
		assertEquals(testeCC.size(), 1);
		assertEquals(testeCC.get(0), "nome");

		// "nomeComposto" para "nome", "composto"
		testeCC = cc.converterCamelCase("nomeComposto");
		assertEquals(testeCC.size(), 2);
		assertEquals(testeCC.get(0), "nome");
		assertEquals(testeCC.get(1), "composto");

		// "CPF" para "CPF"
		testeCC = cc.converterCamelCase("CPF");
		assertEquals(testeCC.size(), 1);
		assertEquals(testeCC.get(0), "CPF");

		// "numeroCPF" para "numero", "CPF"
		testeCC = cc.converterCamelCase("numeroCPF");
		assertEquals(testeCC.size(), 2);
		assertEquals(testeCC.get(0), "numero");
		assertEquals(testeCC.get(1), "CPF");

		// "numeroCPFContribuinte" para "numero", "CPF", "contribuinte"
		testeCC = cc.converterCamelCase("numeroCPFContribuinte");
		assertEquals(testeCC.size(), 3);
		assertEquals(testeCC.get(0), "numero");
		assertEquals(testeCC.get(1), "CPF");
		assertEquals(testeCC.get(2), "contribuinte");
	}
}
