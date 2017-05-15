package br.usjt.arqdesis.service;

import java.util.ArrayList;

import br.usjt.arqdesis.dao.EmpresaDAO;
import br.usjt.arqdesis.model.Empresa;
import br.usjt.arqdesis.model.Usuario;

public class EmpresaService {
	EmpresaDAO empDao = new EmpresaDAO();
	
	public int criar(Empresa empresa) {
		return empDao.criar(empresa);
	}
	
	public void atualizar(Empresa empresa){
		empDao.atualizar(empresa);
	}
	
	public void excluir(int id){
		empDao.excluir(id);
	}
	
	public Empresa carregar(int id){
		return empDao.carregar(id);
	}

	public ArrayList<Empresa> listarEmpresas() {
		return empDao.listarEmpresas();
	}
	
	public ArrayList<Empresa> listarEmpresas(String chave){
		return empDao.listarEmpresas(chave);
	}
}
