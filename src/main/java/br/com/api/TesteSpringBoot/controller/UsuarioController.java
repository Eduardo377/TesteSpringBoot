package br.com.api.TesteSpringBoot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.TesteSpringBoot.DAO.UsuarioDAO;
import br.com.api.TesteSpringBoot.dto.UsuarioDTO;
import br.com.api.TesteSpringBoot.model.Usuario;

@RestController
public class UsuarioController {

	@Autowired
	private UsuarioDAO dao;
	
	@GetMapping("/usuarios/username")
	public ResponseEntity<List<UsuarioDTO>> exibirUsername() {
		List<UsuarioDTO> res = dao.recuperarUsername();
			return ResponseEntity.status(200).body(res);

	}

	@GetMapping("/usuarios")
	public ResponseEntity<List<Usuario>> exibirTodosOsUsuarios() {
		List<Usuario> res = (List<Usuario>) dao.findAll();

		if (res != null) {
			return ResponseEntity.status(200).body(res);
		}

		return ResponseEntity.status(404).build();
	}
	
	@GetMapping("/usuarios/{id}")
	public ResponseEntity<?> mostrarUmUsuario(@PathVariable Integer id) {

		Usuario res = dao.findById(id).orElse(null);

		if (res != null) {
			Usuario u = new Usuario(res.getUsername(), res.getEmail()); 
			return ResponseEntity.status(200).body(u);
		}

		return ResponseEntity.status(404).build();
	}

	@GetMapping("/usuarios/username/{id}")
	public ResponseEntity<?> mostrarUsernameUmUsuario(@PathVariable Integer id) {

		Usuario res = dao.findById(id).orElse(null);

		if (res != null) {
			UsuarioDTO u = new UsuarioDTO(res.getUsername(), res.getEmail()); 
			return ResponseEntity.status(200).body(u);
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
	
	@DeleteMapping("/usuario/{id}")
	public ResponseEntity<?> deletarUsuario(@PathVariable Integer id) {
		Usuario usr = (Usuario) dao.findById(id).orElse(null);
		if (usr != null) {
			try {
				dao.deleteById(id);
				return ResponseEntity.status(204).build();
			} catch (Exception e) {
				// TODO: handle exception
				return ResponseEntity.status(400).body(e.getMessage());
			}
		}
		return ResponseEntity.notFound().build();
	}

}










