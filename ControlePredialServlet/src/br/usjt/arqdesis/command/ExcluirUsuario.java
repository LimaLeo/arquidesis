package br.usjt.arqdesis.command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.usjt.arqdesis.model.Usuario;
import br.usjt.arqdesis.service.UsuarioService;

public class ExcluirUsuario implements Command {

	@Override
	public void executar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int pIdUsuario = Integer.parseInt(request.getParameter("id-usuario"));
        
        //instanciar o javabean
        Usuario usuario = new Usuario();
        
        //instanciar o service
        UsuarioService us = new UsuarioService();
        usuario = us.carregar(pIdUsuario);
        us.excluir(usuario.getIdUsuario());
        
        //enviar para o jsp
        request.setAttribute("usuario", usuario);
        
        RequestDispatcher view = 
        request.getRequestDispatcher("Usuario.jsp");
        view.forward(request, response);	
	}

}
