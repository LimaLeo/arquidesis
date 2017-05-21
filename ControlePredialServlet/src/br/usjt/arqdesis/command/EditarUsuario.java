package br.usjt.arqdesis.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.usjt.arqdesis.model.Usuario;
import br.usjt.arqdesis.service.UsuarioService;

public class EditarUsuario implements Command {

	@Override
	public void executar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String pId = request.getParameter("id");
		String pNome = request.getParameter("nome");
		String pCpf = request.getParameter("cpf");
		String pLogin = request.getParameter("login");
		String pSenha = request.getParameter("senha");
		String pTipoUsuario = request.getParameter("tipo-usuario");

		int id = -1;
		try {
			id = Integer.parseInt(pId);
		} catch (NumberFormatException e) {

		}

		Usuario usuario = new Usuario();
		usuario.setIdUsuario(id);
		usuario.setNomeUsuario(pNome);
		usuario.setCpf(pCpf);
		usuario.setLogin(pLogin);
		usuario.setSenha(pSenha);
		usuario.setTipoUsuario(pTipoUsuario);
		UsuarioService us = new UsuarioService();

		RequestDispatcher view = null;
		HttpSession session = request.getSession();

		usuario = us.carregar(usuario.getIdUsuario());
		request.setAttribute("usuario", usuario);
		view = request.getRequestDispatcher("AlterarUsuario.jsp");

		view.forward(request, response);

	}

	public int busca(Usuario usuario, ArrayList<Usuario> lista) {
		Usuario to;
		for (int i = 0; i < lista.size(); i++) {
			to = lista.get(i);
			if (to.getIdUsuario() == usuario.getIdUsuario()) {
				return i;
			}
		}
		return -1;
	}

}
