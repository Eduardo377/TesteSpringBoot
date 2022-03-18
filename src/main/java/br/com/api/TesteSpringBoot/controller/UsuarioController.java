package br.com.api.TesteSpringBoot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.TesteSpringBoot.DAO.UsuarioDAO;
import br.com.api.TesteSpringBoot.model.Usuario;

@RestController
public class UsuarioController {

	@Autowired
	UsuarioDAO dao;

	@GetMapping("/teste")
	public ResponseEntity<List<Usuario>> exibirTodosOsUsuarios() {
		List<Usuario> res = (List<Usuario>) dao.findAll();

		if (res != null) {
			return ResponseEntity.status(200).body(res);
		}

		return ResponseEntity.status(404).build();
	}

	@GetMapping("/teste/{id}")
	public ResponseEntity<?> mostrarUmUsuario(@PathVariable Integer id) {

		Usuario res = (Usuario) dao.findById(id).orElse(null);

		if (res != null) {
			return ResponseEntity.status(200).body(res);
		}

		return ResponseEntity.status(404).build();
	}

	@PostMapping("/usuario")
	public ResponseEntity<?> novoUsuario(@RequestBody Usuario novo) {
		String nome = novo.getNome();

		if (nome == null) {
			return ResponseEntity.badRequest().body("The field nome is obrigatory");
		}

		try {
			Usuario res = (Usuario) dao.save(novo);
			return ResponseEntity.status(200).body(res);
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(400).body(e.getMessage());
		}
	}

	@PutMapping("/usuario/{id}")
	public ResponseEntity<?> updateUsuario(@RequestBody Usuario usuarioAtualizado, @PathVariable Integer id) {

		Usuario usr = (Usuario) dao.findById(id).orElse(null);
		if (usr != null) {
			try {
				usuarioAtualizado.setId(id);
				Usuario res = (Usuario) dao.save(usuarioAtualizado);
				return ResponseEntity.badRequest().body(res);

			} catch (Exception e) {
				// TODO: handle exception
				return ResponseEntity.status(400).body(e.getMessage());
			}

		}
		return ResponseEntity.status(404).build();

	}

}