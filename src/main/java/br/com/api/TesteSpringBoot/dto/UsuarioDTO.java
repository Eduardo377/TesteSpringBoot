package br.com.api.TesteSpringBoot.dto;

import br.com.api.TesteSpringBoot.model.Usuario;

public class UsuarioDTO {
	private String username;
	private String email;

	public UsuarioDTO(String username, String email) {
		super();
		this.username = username;
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public static UsuarioDTO fromUsuario(Usuario u) {
		return new UsuarioDTO(u.getUsername(), u.getEmail());

	}

}
