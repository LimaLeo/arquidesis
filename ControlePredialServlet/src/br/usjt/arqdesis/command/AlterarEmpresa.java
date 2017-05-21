package br.usjt.arqdesis.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.usjt.arqdesis.model.Empresa;
import br.usjt.arqdesis.model.Usuario;
import br.usjt.arqdesis.service.EmpresaService;

public class AlterarEmpresa implements Command {

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
		
		int temperatura = -1;
		try {
			temperatura = Integer.parseInt(pTemperaturaMaximaAr);
		} catch (NumberFormatException e) {

		}
		
        //instanciar o javabean
        Empresa empresa = new Empresa();
        empresa.setIdEmpresa(id);
        empresa.setRazaoSocial(pRazaoSocial);
        empresa.setCnpj(pCnpj);
        empresa.setHorarioDeFuncionamento(pHorarioDeFuncionamento);
        empresa.setTemperaturaMaximaAr(temperatura);
        
        //instanciar o service
        EmpresaService es = new EmpresaService();
        es.atualizar(empresa);
        empresa = es.carregar(empresa.getIdEmpresa());
        
        //enviar para o jsp
        RequestDispatcher view = null;
		HttpSession session = request.getSession();

		es.atualizar(empresa);
		@SuppressWarnings("unchecked")
		ArrayList<Empresa> lista = (ArrayList<Empresa>) session
				.getAttribute("lista");
		int pos = busca(empresa, lista);
		lista.remove(pos);
		lista.add(pos, empresa);
		session.setAttribute("lista", lista);
		request.setAttribute("empresa", empresa);
		view = request.getRequestDispatcher("VisualizarEmpresa.jsp");

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
