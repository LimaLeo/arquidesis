package br.usjt.arqdesis.test;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.usjt.arqdesis.model.*;
import br.usjt.arqdesis.service.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmpresaTest {

		Empresa empresa, copia;
		EmpresaService empService;
		static int id = 0;

		@Before
		public void setUp() throws Exception {
			System.out.println("Setup Empresa");
			empresa = new Empresa();
			empresa.setIdEmpresa(id);
			empresa.setCnpj("12.345.678/0001-99");
			empresa.setRazaoSocial("Razao");
			empresa.setHorarioDeFuncionamento("18:00");
			empresa.setTemperaturaMaximaAr(20);
			
			copia = new Empresa();
			copia.setIdEmpresa(id);
			copia.setCnpj("12.345.678/0001-99");
			copia.setRazaoSocial("Razao");
			copia.setHorarioDeFuncionamento("18:00");
			copia.setTemperaturaMaximaAr(20);
			
			empService = new EmpresaService();
			System.out.println(empresa);
			System.out.println(copia);
			System.out.println(id);
		}
		
		@Test
		public void test00Criar() {
			System.out.println("Criar a Empresa");
			id = empService.criar(empresa);
			System.out.println(id);
			copia.setIdEmpresa(id);
			assertEquals("Teste de Criação", empresa, copia);
		}

		@Test
		public void test01Carregar() {
			System.out.println("Buscar os Dados da Empresa");
			Empresa novo = empService.carregar(1);
			assertEquals("Teste de Inclusão", novo, copia);
		}
		
		@Test
		public void test02Atualizar() {
			System.out.println("Atualizar a Empresa");
			empresa.setCnpj("99.876.543/0001-21");
			empresa.setRazaoSocial("Social");
			copia.setCnpj("99.876.543/0001-21");
			copia.setRazaoSocial("Social");
			empService.atualizar(empresa);
			empresa = empService.carregar(empresa.getIdEmpresa());
			assertEquals("Teste de Atualização", empresa, copia);
		}

		
		@Test
		public void test03Excluir() {
			System.out.println("Excluir a Empresa");
			copia.setIdEmpresa(-1);
			copia.setCnpj(null);
			copia.setRazaoSocial(null);
			copia.setHorarioDeFuncionamento(null);
			copia.setTemperaturaMaximaAr(-1);
			empService.excluir(id);
			empresa = empService.carregar(id);
			assertEquals("Teste de Exclusão", empresa, copia);
		}
}
