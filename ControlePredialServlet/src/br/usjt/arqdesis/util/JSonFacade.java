package br.usjt.arqdesis.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import br.usjt.arqdesis.model.Usuario;

public class JSonFacade {
	
	public static StringBuilder montaJSon(HttpServletRequest request)
			throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader reader = request.getReader();
		try {
			String line;
			while ((line = reader.readLine()) != null) {
				sb.append(line).append('\n');
			}
		} finally {
			reader.close();
		}
		return sb;
	}

	public static String listToJSon(ArrayList<Usuario> lista) {
		JSONArray vetor = new JSONArray();
		for (Usuario to : lista) {
			JSONObject object = new JSONObject();
			try {
				object.put("id", to.getIdUsuario());
				object.put("nome", to.getNomeUsuario());
				object.put("cpf", to.getCpf());
				object.put("login", to.getLogin());
				object.put("senha", to.getSenha());
				object.put("tipo_usuario", to.getTipoUsuario());
				vetor.put(object);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return vetor.toString();
	}

	public static Usuario jSonToCliente(String json) throws IOException{
		try{
			JSONObject registro = new JSONObject(json);
			int id = registro.getInt("id");
			String nome = registro.getString("nome");
			String cpf = registro.getString("cpf");
			String login = registro.getString("login");
			String senha = registro.getString("senha");
			String tipoUsuario = registro.getString("tipoUsuario");
			Usuario usuario = new Usuario();
			usuario.setIdUsuario(id);
			usuario.setNomeUsuario(nome);
			usuario.setCpf(cpf);
			usuario.setLogin(login);
			usuario.setSenha(senha);
			usuario.setTipoUsuario(tipoUsuario);
			return usuario;
		} catch(JSONException jsone){
			jsone.printStackTrace();
			throw new IOException(jsone);
		}
	}
	
	public static String clienteToJSon(Usuario usuario) throws IOException {
		JSONObject object = new JSONObject();
		try {
			object.put("id", usuario.getIdUsuario());
			object.put("nome", usuario.getNomeUsuario());
			object.put("cpf", usuario.getCpf());
			object.put("login", usuario.getLogin());
			object.put("senha", usuario.getSenha());
			object.put("tipoUsuario", usuario.getTipoUsuario());
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return object.toString();
	}

	public static String errorToJSon(Exception e) {
		JSONObject object = new JSONObject();
		try {
			object.put("error", e.toString());
		} catch (JSONException e1) {
			e.printStackTrace();
		}
		return object.toString();
	}
}
