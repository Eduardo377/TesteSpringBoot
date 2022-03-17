package br.com.api.TesteSpringBoot.DAO;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import br.com.api.TesteSpringBoot.model.Usuario;

public interface UsuarioDAO extends CrudRepository<Usuario, Integer>{


}
