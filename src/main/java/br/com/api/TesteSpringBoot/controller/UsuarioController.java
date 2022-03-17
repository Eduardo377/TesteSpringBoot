package br.com.api.TesteSpringBoot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.TesteSpringBoot.DAO.UsuarioDAO;
import br.com.api.TesteSpringBoot.model.Usuario;
import br.com.educorp.ecommerce.model.Departamento;

@RestController
public class UsuarioController {
	
	@Autowired
	UsuarioDAO dao;

	@GetMapping("/teste")
	public ResponseEntity<List<Usuario>> exibirTodosOsUsuarios() {
		List<Usuario> res = (List<Usuario>) dao.findAll();
		
		if (res !=  null) {			
			return ResponseEntity.status(200).body(res);
		}
		
		return ResponseEntity.status(404).build();
	}
	
	@GetMapping("/teste/{id}")
	public ResponseEntity<?> mostrarUmUsuario(@PathVariable Integer id){
		
		Usuario res =  (Usuario) dao.findById(id).orElse(null);
 		
		if (res !=  null) {			
			return ResponseEntity.status(200).body(res);
		}
		
		return ResponseEntity.status(404).build();
	}

}