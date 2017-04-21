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
@WebServlet("/ConsultarUsuario.do")
public class ConsultarUsuarioController extends HttpServlet {
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
    	String btn = request.getParameter("btn");
    	
        //instanciar o javabean
        Usuario usuario = new Usuario();
        
        //instanciar o service
        UsuarioService us = new UsuarioService();
        usuario = us.carregar(pIdUsuario);
        
        //enviar para o jsp
        request.setAttribute("usuario", usuario);
        RequestDispatcher view;
        
        if( btn.equals("editar") ){
        	view = request.getRequestDispatcher("AlterarUsuario.jsp");

        }else{
            view = request.getRequestDispatcher("Usuario.jsp");
        }
        view.forward(request, response);
        
    }
    
    
}
