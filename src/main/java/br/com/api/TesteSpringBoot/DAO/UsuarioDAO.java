package br.com.api.TesteSpringBoot.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.api.TesteSpringBoot.dto.UsuarioDTO;
import br.com.api.TesteSpringBoot.model.Usuario;

public interface UsuarioDAO extends CrudRepository<Usuario, Integer> {
	@Query("SELECT new br.com.api.TesteSpringBoot.dto.UsuarioDTO(usuario.username, usuario.email) FROM Usuario as usuario")
	public List<UsuarioDTO> recuperarUsername();
}
