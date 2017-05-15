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

public class ListarEmpresasBuscar implements Command {

	@Override
	public void executar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String chave = request.getParameter("data[search]");
		EmpresaService empresa = new EmpresaService();
		ArrayList<Empresa> lista = null;
		HttpSession session = request.getSession();
		if (chave != null && chave.length() > 0) {
			lista = empresa.listarEmpresas(chave);
		} else {
			lista = empresa.listarEmpresas();
		}
		session.setAttribute("lista", lista);

		RequestDispatcher dispatcher = request
				.getRequestDispatcher("ListarEmpresas.jsp");
		dispatcher.forward(request, response);

	}

}
