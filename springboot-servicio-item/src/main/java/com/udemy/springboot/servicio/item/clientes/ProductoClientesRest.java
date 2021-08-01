package com.udemy.springboot.servicio.item.clientes;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.udemy.springboot.servicio.item.models.Item;
import com.udemy.springboot.servicio.item.models.Producto;

@FeignClient(name="servicio-productos")
public interface ProductoClientesRest {

	@GetMapping("/listar")
	public List<Producto> listar();
	
	@GetMapping("/ver/{id}")
	public Producto detalle(@PathVariable Long id);
	
}
