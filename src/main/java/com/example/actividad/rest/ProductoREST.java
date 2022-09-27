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
import com.example.actividad.model.Producto;
import com.example.actividad.service.ProductoService;

@RestController
@RequestMapping ("/producto/")
public class ProductoREST {
	
	@Autowired
	private ProductoService productoService;
	
	
	@GetMapping
	public ResponseEntity<List<Producto>> getAllProductos(){
		
			return ResponseEntity.ok(productoService.findAll());
			
	}
	
	@PostMapping
	private ResponseEntity<Producto> saveProducto (@RequestBody Producto producto){
		try {
			
			Producto productoGuardado = productoService.save(producto);
			return ResponseEntity.created(new URI("/producto/"+productoGuardado.getIdProducto())).body(productoGuardado);
			
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	

}
}
