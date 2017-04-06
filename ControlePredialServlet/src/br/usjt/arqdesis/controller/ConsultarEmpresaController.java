package br.usjt.arqdesis.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.usjt.arqdesis.model.Empresa;
import br.usjt.arqdesis.service.EmpresaService;


/**
 * Servlet implementation class ManterClienteController
 */
@WebServlet("/ConsultarEmpresa.do")
public class ConsultarEmpresaController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
    
    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	int pIdEmpresa = Integer.parseInt(request.getParameter("id-empresa"));
        
        //instanciar o javabean
        Empresa empresa = new Empresa();
        
        //instanciar o service
        EmpresaService es = new EmpresaService();
        empresa = es.carregar(pIdEmpresa);
        
        //enviar para o jsp
        request.setAttribute("empresa", empresa);
        
        RequestDispatcher view = 
        request.getRequestDispatcher("Empresa.jsp");
        view.forward(request, response);
        
    }
	
}
