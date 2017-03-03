package br.usjt.arqdesis.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import br.usjt.arqdesis.model.Usuario;

public class UsuarioDAO {
	
	public int criar(Usuario usuario) {
		String sqlInsert = "INSERT INTO USUARIO(NOME, CPF, LOGIN, SENHA, TIPO_USUARIO) VALUES (?, ?, ?, ?, ?)";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement ps = conn.prepareStatement(sqlInsert);) {
			ps.setString(1, usuario.getNomeUsuario());
			ps.setString(2, usuario.getCpf());
			ps.setString(3, usuario.getLogin());
			ps.setString(4, usuario.getSenha());
			ps.setString(5, usuario.getTipoUsuario());
			ps.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
					ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					usuario.setIdUsuario(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return usuario.getIdUsuario();
	}

	public void atualizar(Usuario usuario) {
		String sqlUpdate = "UPDATE USUARIO SET NOME=?, CPF=? WHERE ID=?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement ps = conn.prepareStatement(sqlUpdate);) {
			ps.setString(1, usuario.getNomeUsuario());
			ps.setString(2, usuario.getCpf());
			ps.setInt(3, usuario.getIdUsuario());
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excluir(int id) {
		String sqlDelete = "DELETE FROM USUARIO WHERE ID= ?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement ps = conn.prepareStatement(sqlDelete);) {
			ps.setInt(1, id);
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Usuario carregar(int id) {
		Usuario usuario = new Usuario();
		usuario.setIdUsuario(id);
		String sqlSelect = "SELECT NOME, CPF, LOGIN, SENHA, TIPO_USUARIO FROM USUARIO WHERE USUARIO.ID=?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement ps = conn.prepareStatement(sqlSelect);) {
			ps.setInt(1, usuario.getIdUsuario());
			try (ResultSet rs = ps.executeQuery();) {
				if (rs.next()) {
					usuario.setNomeUsuario(rs.getString("NOME"));
					usuario.setCpf(rs.getString("CPF"));
					usuario.setLogin(rs.getString("LOGIN"));
					usuario.setSenha(rs.getString("SENHA"));
					usuario.setTipoUsuario(rs.getString("TIPO_USUARIO"));
				} else {
					usuario.setIdUsuario(-1);
					usuario.setNomeUsuario(null);
					usuario.setCpf(null);
					usuario.setLogin(null);
					usuario.setSenha(null);
					usuario.setTipoUsuario(null);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return usuario;
	}
	
}
