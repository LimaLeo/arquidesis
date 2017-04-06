package br.usjt.arqdesis.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.usjt.arqdesis.model.Usuario;
import br.usjt.arqdesis.service.UsuarioService;

/**
 * Servlet implementation class ManterUsuarioController
 */
@WebServlet("/AlterarUsuario.do")
public class AlterarUsuarioController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
    
    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	int pIdUsuario = Integer.parseInt(request.getParameter("id-usuario"));
    	String pNome = request.getParameter("nome");
    	String pTipoUsuario = request.getParameter("tipo-usuario");
        String pCpf = request.getParameter("cpf");
        String pLogin = request.getParameter("login");
        String pSenha = request.getParameter("senha");
        
        //instanciar o javabean
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(pIdUsuario);
        usuario.setNomeUsuario(pNome);
        usuario.setTipoUsuario(pTipoUsuario);
        usuario.setCpf(pCpf);
        usuario.setLogin(pLogin);
        usuario.setSenha(pSenha);
        
        //instanciar o service
        UsuarioService us = new UsuarioService();
        us.atualizar(usuario);
        usuario = us.carregar(usuario.getIdUsuario());
        
        //enviar para o jsp
        request.setAttribute("usuario", usuario);
        
        RequestDispatcher view = 
        request.getRequestDispatcher("Usuario.jsp");
        view.forward(request, response);
        
    }
    
    
}
