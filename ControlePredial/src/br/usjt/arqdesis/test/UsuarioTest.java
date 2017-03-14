package br.usjt.arqdesis.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.usjt.arqdesis.model.Usuario;
import br.usjt.arqdesis.service.UsuarioService;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UsuarioTest {

		Usuario usuario, copia;
		UsuarioService us;
		static int id = 0;

		@Before
		public void setUp() throws Exception {
			System.out.println("Setup Usuario");
			usuario = new Usuario();
			usuario.setIdUsuario(id);
			usuario.setNomeUsuario("Fulano da Silva");
			usuario.setCpf("12345678901");
			usuario.setLogin("fulano");
			usuario.setSenha("123456789");
			usuario.setTipoUsuario("F");
			copia = new Usuario();
			copia.setIdUsuario(id);
			copia.setNomeUsuario("Fulano da Silva");
			copia.setCpf("12345678901");
			copia.setLogin("fulano");
			copia.setSenha("123456789");
			copia.setTipoUsuario("F");
			us = new UsuarioService();
			System.out.println(usuario);
			System.out.println(copia);
			System.out.println(id);
		}
		
		@Test
		public void test00Criar() {
			System.out.println("Criar o Usu�rio");
			id = us.criar(usuario);
			System.out.println(id);
			copia.setIdUsuario(id);
			assertEquals("Teste de Cria��o", usuario, copia);
		}

		@Test
		public void test01Carregar() {
			System.out.println("Buscar os Dados do Usu�rio");
			Usuario novo = us.carregar(1);
			assertEquals("Teste de Inclus�o", novo, copia);
		}
		
		@Test
		public void test02Atualizar() {
			System.out.println("Atualizar o Usu�rio");
			usuario.setCpf("10123456789");
			usuario.setNomeUsuario("Ciclano da Silva");
			copia.setCpf("10123456789");
			copia.setNomeUsuario("Ciclano da Silva");
			us.atualizar(usuario);
			usuario = us.carregar(usuario.getIdUsuario());
			assertEquals("Teste de Atualiza��o", usuario, copia);
		}

		
		@Test
		public void test03Excluir() {
			System.out.println("Excluir o Usu�rio");
			copia.setIdUsuario(-1);
			copia.setNomeUsuario(null);
			copia.setCpf(null);
			copia.setLogin(null);
			copia.setSenha(null);
			copia.setTipoUsuario(null);
			us.excluir(id);
			usuario = us.carregar(id);
			assertEquals("Teste de Exclus�o", usuario, copia);
		}
}
