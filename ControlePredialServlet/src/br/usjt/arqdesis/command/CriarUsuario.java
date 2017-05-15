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

public class CriarUsuario implements Command{

	@Override
	public void executar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String pIdUsuario = request.getParameter("id");
		String pNome = request.getParameter("nome");
    	String pTipoUsuario = request.getParameter("tipo-usuario");
        String pCpf = request.getParameter("cpf");
        String pLogin = request.getParameter("login");
        String pSenha = request.getParameter("senha");
        
        int id = -1;
        try {
			id = Integer.parseInt(pIdUsuario);
		} catch (NumberFormatException e) {

		}
		
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(id);
        usuario.setNomeUsuario(pNome);
        usuario.setTipoUsuario(pTipoUsuario);
        usuario.setCpf(pCpf);
        usuario.setLogin(pLogin);
        usuario.setSenha(pSenha);
        UsuarioService us = new UsuarioService();
        
        RequestDispatcher view = null;
        HttpSession session = request.getSession();
        
        us.criar(usuario);
        ArrayList<Usuario> lista = new ArrayList<>();
        lista.add(usuario);
        session.setAttribute("lista", lista);
        view = request.getRequestDispatcher("ListarUsuarios.jsp");
        
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
