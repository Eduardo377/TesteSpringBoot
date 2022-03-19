package br.com.api.TesteSpringBoot.service;

import br.com.api.TesteSpringBoot.model.Usuario;

public interface IUsuarioService {
	public Usuario deleteUsuario(Usuario usuarioDelete);
	public Usuario updateUsuario(Usuario usuarioUpdate);
	public Usuario criarUsuario(Usuario  usuarioNovo);
}
