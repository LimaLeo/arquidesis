package br.usjt.arqdesis.service;

import br.usjt.arqdesis.dao.EmpresaDAO;
import br.usjt.arqdesis.model.Empresa;

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
}
