package br.usjt.arqdesis.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.usjt.arqdesis.model.Empresa;
import br.usjt.arqdesis.service.EmpresaService;

public class CriarEmpresa implements Command {

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
        EmpresaService es = new EmpresaService();
        
        RequestDispatcher view = null;
        HttpSession session = request.getSession();
        
        es.criar(empresa);
        ArrayList<Empresa> lista = new ArrayList<>();
        lista.add(empresa);
        session.setAttribute("lista", lista);
        view = request.getRequestDispatcher("ListarEmpresas.jsp");
        
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
