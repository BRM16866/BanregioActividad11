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
import com.example.actividad.repository.CategoriaRepository;

public class CategoriaServiceTest {
	
	@Mock
	private CategoriaRepository categoriaRepository;
	
	@InjectMocks
	private CategoriaService categoriaService;
	
	private Categoria categoria;
	
	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(categoriaRepository);
		
		categoria = new Categoria();
		categoria.setIdCategoria((long) 1);
		categoria.setDescripcion("articulos deportivos");
		categoria.setNombre("deportes");
		
	}
	
	@Test
	void save() {
		when(categoriaRepository.save(any(Categoria.class))).thenReturn(categoria);
		assertNotNull(categoriaService.save(new Categoria()));
	}

}
