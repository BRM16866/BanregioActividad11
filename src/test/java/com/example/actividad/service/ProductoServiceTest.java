package com.example.actividad.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.actividad.model.Categoria;
import com.example.actividad.model.Producto;

import com.example.actividad.repository.ProductoRepository;

public class ProductoServiceTest {
	
	@Mock
	private ProductoRepository productoRepository;
	
	@InjectMocks
	private ProductoService productoService;
	
	private Producto producto;
	
	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(productoRepository);
		
		producto = new Producto();
		producto.setIdProducto((long) 1);
		producto.setNombre("Balon");
		producto.setPrecio(260);
		producto.setStock(5);
		producto.setCategoria(new Categoria());
		
	}
	
	@Test
	void save() {
		when(productoRepository.save(any(Producto.class))).thenReturn(producto);
		assertNotNull(productoService.save(new Producto()));
	}
	

}
