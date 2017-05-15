package br.usjt.arqdesis.command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.usjt.arqdesis.model.Empresa;
import br.usjt.arqdesis.service.EmpresaService;

public class VisualizarEmpresa implements Command {

	@Override
	public void executar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String pIdEmpresa = request.getParameter("id");
		String pRazaoSocial = request.getParameter("razao-social");
    	String pCnpj = request.getParameter("cnpj");
        String pHorarioDeFuncionamento = request.getParameter("horario-de-funcionamento");
        String pTemperaturaMaximaAr = request.getParameter("temperatura-maxima-ar");
        
        int id = -1;
        try {
			id = Integer.parseInt(pIdEmpresa);
		} catch (NumberFormatException e) {

		}
        
        Empresa empresa = new Empresa();
        empresa.setIdEmpresa(id);
        empresa.setRazaoSocial(pRazaoSocial);
        empresa.setCnpj(pCnpj);
        empresa.setHorarioDeFuncionamento(pHorarioDeFuncionamento);
        empresa.setTemperaturaMaximaAr(Integer.parseInt(pTemperaturaMaximaAr));
		
		RequestDispatcher view = null;

        EmpresaService es = new EmpresaService();
      
        empresa = es.carregar(empresa.getIdEmpresa());
		request.setAttribute("empresa", empresa);

		view = request.getRequestDispatcher("VisualizarEmpresa.jsp");
        view.forward(request, response);

		
	}

}
