package br.usjt.arqdesis.command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.usjt.arqdesis.model.Usuario;
import br.usjt.arqdesis.service.UsuarioService;

public class VisualizarUsuario implements Command {

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
        
        RequestDispatcher view = null;
        
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(id);
        usuario.setNomeUsuario(pNome);
        usuario.setTipoUsuario(pTipoUsuario);
        usuario.setCpf(pCpf);
        usuario.setLogin(pLogin);
        usuario.setSenha(pSenha);
        
        UsuarioService us = new UsuarioService();
        usuario = us.carregar(usuario.getIdUsuario());
        request.setAttribute("usuario", usuario);
        
        view = request.getRequestDispatcher("VisualizarUsuario.jsp");
        view.forward(request, response);

    }

}
