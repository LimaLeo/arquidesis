package br.usjt.arqdesis.service;

import br.usjt.arqdesis.dao.UsuarioDAO;
import br.usjt.arqdesis.model.Usuario;

public class UsuarioService {
		UsuarioDAO uDao = new UsuarioDAO();
		
		public int criar(Usuario usuario) {
			return uDao.criar(usuario);
		}
		
		public void atualizar(Usuario usuario){
			uDao.atualizar(usuario);
		}
		
		public void excluir(int id){
			uDao.excluir(id);
		}
		
		public Usuario carregar(int id){
			return uDao.carregar(id);
		}

}