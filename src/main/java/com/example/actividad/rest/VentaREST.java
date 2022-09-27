package com.example.actividad.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.actividad.model.Producto;
import com.example.actividad.service.ProductoService;

@RestController
@RequestMapping("/user/")
public class VentaREST {
	
	@Autowired
	private ProductoService productoService;
	
	@GetMapping("/producto")
	public ResponseEntity<List<Producto>> getAllProductos(){
		
			return ResponseEntity.ok(productoService.findAll());
			
	}

}
