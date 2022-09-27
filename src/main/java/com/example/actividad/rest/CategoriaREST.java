package com.example.actividad.rest;

import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.actividad.model.Categoria;
import com.example.actividad.service.CategoriaService;

@RestController
@RequestMapping ("/categoria/")
public class CategoriaREST {
	
	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping
	private ResponseEntity<List<Categoria>> getAllCategorias(){
		
			return ResponseEntity.ok(categoriaService.findAll());
			
	}
	
	@PostMapping
	private ResponseEntity<Categoria> saveCategoria (@RequestBody Categoria categoria){
		try {
			
			Categoria categoriaGuardada = categoriaService.save(categoria);
			return ResponseEntity.created(new URI("/categoria/"+categoriaGuardada.getIdCategoria())).body(categoriaGuardada);
			
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
	}
	
	
}
