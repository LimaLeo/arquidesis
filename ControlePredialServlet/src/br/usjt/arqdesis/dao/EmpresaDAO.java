package br.usjt.arqdesis.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.usjt.arqdesis.model.Empresa;

public class EmpresaDAO {
	
	public int criar(Empresa empresa) {
		String sqlInsert = "INSERT INTO EMPRESA(CNPJ, RAZAO_SOCIAL, HORARIO_FUNCIONAMENTO, TEMPERATURA_MAXIMA_AR) VALUES (?, ?, ?, ?)";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement ps = conn.prepareStatement(sqlInsert);) {
			ps.setString(1, empresa.getCnpj());
			ps.setString(2, empresa.getRazaoSocial());
			ps.setString(3, empresa.getHorarioDeFuncionamento());
			ps.setInt(4, empresa.getTemperaturaMaximaAr());
			ps.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
					ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					empresa.setIdEmpresa(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return empresa.getIdEmpresa();
	}

	public void atualizar(Empresa empresa) {
		String sqlUpdate = "UPDATE EMPRESA SET CNPJ = ?, RAZAO_SOCIAL = ?, HORARIO_FUNCIONAMENTO = ?, TEMPERATURA_MAXIMA_AR = ? WHERE ID = ?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement ps = conn.prepareStatement(sqlUpdate);) {
			ps.setString(1, empresa.getCnpj());
			ps.setString(2, empresa.getRazaoSocial());
			ps.setString(3, empresa.getHorarioDeFuncionamento());
			ps.setInt(4, empresa.getTemperaturaMaximaAr());
			ps.setInt(5, empresa.getIdEmpresa());
			
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excluir(int id) {
		String sqlDelete = "DELETE FROM EMPRESA WHERE ID= ?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement ps = conn.prepareStatement(sqlDelete);) {
			ps.setInt(1, id);
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Empresa carregar(int id) {
		Empresa empresa = new Empresa();
		empresa.setIdEmpresa(id);
		String sqlSelect = "SELECT CNPJ, RAZAO_SOCIAL, HORARIO_FUNCIONAMENTO, TEMPERATURA_MAXIMA_AR FROM EMPRESA WHERE EMPRESA.ID = ?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement ps = conn.prepareStatement(sqlSelect);) {
			ps.setInt(1, empresa.getIdEmpresa());
			try (ResultSet rs = ps.executeQuery();) {
				if (rs.next()) {
					empresa.setCnpj(rs.getString("CNPJ"));
					empresa.setRazaoSocial(rs.getString("RAZAO_SOCIAL"));
					empresa.setHorarioDeFuncionamento(rs.getString("HORARIO_FUNCIONAMENTO"));
					empresa.setTemperaturaMaximaAr(rs.getInt("TEMPERATURA_MAXIMA_AR"));
				} else {
					empresa.setIdEmpresa(-1);
					empresa.setRazaoSocial(null);
					empresa.setHorarioDeFuncionamento(null);
					empresa.setTemperaturaMaximaAr(-1);					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return empresa;
	}

	public ArrayList<Empresa> listarEmpresas() {
		Empresa empresa;
		
		ArrayList<Empresa> lista = new ArrayList<Empresa>();
		
		String sqlSelect = "SELECT ID, CNPJ, RAZAO_SOCIAL, HORARIO_FUNCIONAMENTO, TEMPERATURA_MAXIMA_AR FROM empresa;";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					
					empresa = new Empresa();
					empresa.setIdEmpresa(rs.getInt("ID"));
					empresa.setCnpj(rs.getString("CNPJ"));
					empresa.setRazaoSocial(rs.getString("RAZAO_SOCIAL"));
					empresa.setHorarioDeFuncionamento(rs.getString("HORARIO_FUNCIONAMENTO"));
					empresa.setTemperaturaMaximaAr(rs.getInt("TEMPERATURA_MAXIMA_AR"));
					lista.add(empresa);
					
				} 
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return lista;
	}

	public ArrayList<Empresa> listarEmpresas(String chave) {
		Empresa empresa;
		
		ArrayList<Empresa> lista = new ArrayList<Empresa>();
		
		String sqlSelect = "SELECT ID, CNPJ, RAZAO_SOCIAL, HORARIO_FUNCIONAMENTO, TEMPERATURA_MAXIMA_AR FROM empresa where upper(razao_social) like ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setString(1, "%" + chave.toUpperCase() + "%");
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {					
					empresa = new Empresa();
					empresa.setIdEmpresa(rs.getInt("ID"));
					empresa.setCnpj(rs.getString("CNPJ"));
					empresa.setRazaoSocial(rs.getString("RAZAO_SOCIAL"));
					empresa.setHorarioDeFuncionamento(rs.getString("HORARIO_FUNCIONAMENTO"));
					empresa.setTemperaturaMaximaAr(rs.getInt("TEMPERATURA_MAXIMA_AR"));
					
					lista.add(empresa);					
				} 
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return lista;
	}

}
