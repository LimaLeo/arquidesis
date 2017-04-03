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
@WebServlet("/ManterEmpresa.do")
public class ManterEmpresaController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
    
    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String pRazaoSocial = request.getParameter("razao-social");
    	String pCnpj = request.getParameter("cnpj");
        String pHorarioDeFuncionamento = request.getParameter("horario-de-funcionamento");
        String pTemperaturaMaximaAr = request.getParameter("temperatura-maxima-ar");
        
        
        //instanciar o javabean
        Empresa empresa = new Empresa();
        empresa.setRazaoSocial(pRazaoSocial);
        empresa.setCnpj(pCnpj);
        empresa.setHorarioDeFuncionamento(pHorarioDeFuncionamento);
        empresa.setTemperaturaMaximaAr(Integer.parseInt(pTemperaturaMaximaAr));
        
        //instanciar o service
        EmpresaService es = new EmpresaService();
        es.criar(empresa);
        empresa = es.carregar(empresa.getIdEmpresa());
        
        //enviar para o jsp
        request.setAttribute("empresa", empresa);
        
        RequestDispatcher view = 
        request.getRequestDispatcher("Empresa.jsp");
        view.forward(request, response);
        
    }
	
}
