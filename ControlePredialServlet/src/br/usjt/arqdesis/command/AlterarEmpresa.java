package br.usjt.arqdesis.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.usjt.arqdesis.model.Empresa;
import br.usjt.arqdesis.service.EmpresaService;

public class AlterarEmpresa implements Command {

	@Override
	public void executar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int pIdEmpresa = Integer.parseInt(request.getParameter("id-empresa"));
    	String pRazaoSocial = request.getParameter("razao-social");
    	String pCnpj = request.getParameter("cnpj");
        String pHorarioDeFuncionamento = request.getParameter("horario-de-funcionamento");
        String pTemperaturaMaximaAr = request.getParameter("temperatura-maxima-ar");
        
        
        //instanciar o javabean
        Empresa empresa = new Empresa();
        empresa.setIdEmpresa(pIdEmpresa);
        empresa.setRazaoSocial(pRazaoSocial);
        empresa.setCnpj(pCnpj);
        empresa.setHorarioDeFuncionamento(pHorarioDeFuncionamento);
        empresa.setTemperaturaMaximaAr(Integer.parseInt(pTemperaturaMaximaAr));
        
        //instanciar o service
        EmpresaService es = new EmpresaService();
        es.atualizar(empresa);
        empresa = es.carregar(empresa.getIdEmpresa());
        
        //enviar para o jsp
        request.setAttribute("empresa", empresa);
        
        RequestDispatcher view = 
        request.getRequestDispatcher("Empresa.jsp");
        view.forward(request, response);
	}

	public int busca(Empresa empresa, ArrayList<Empresa> lista) {
		Empresa to;
		for (int i = 0; i < lista.size(); i++) {
			to = lista.get(i);
			if (to.getIdEmpresa() == empresa.getIdEmpresa()) {
				return i;
			}
		}
		return -1;
	}

}
