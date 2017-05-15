package br.usjt.arqdesis.command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.usjt.arqdesis.model.Empresa;
import br.usjt.arqdesis.service.EmpresaService;

public class ExcluirEmpresa implements Command {

	@Override
	public void executar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int pIdEmpresa = Integer.parseInt(request.getParameter("id-empresa"));
        
        //instanciar o javabean
        Empresa empresa = new Empresa();
        
        //instanciar o service
        EmpresaService es = new EmpresaService();
        empresa = es.carregar(pIdEmpresa);
        es.excluir(empresa.getIdEmpresa());
        
        //enviar para o jsp
        request.setAttribute("empresa", empresa);
        
        RequestDispatcher view = 
        request.getRequestDispatcher("Empresa.jsp");
        view.forward(request, response);
	}
}
