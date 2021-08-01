package com.udemy.springboot.servicio.productos.models.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.springboot.servicio.productos.models.entity.Producto;
import com.udemy.springboot.servicio.productos.models.service.IProductoService;

@RestController
public class ProductoController {
	
	@Autowired
	private IProductoService iproductoservice;
	
	@GetMapping("")
	public String bienvenida(){
		return "Página de bienvenida";
	}
	
	@GetMapping("/listar")
	public List<Producto> listar(){
		return iproductoservice.findAll();
	}
	
	@GetMapping("/ver/{id}")
	public Producto detalle(@PathVariable Long id){
		return iproductoservice.findById(id);
	}

}
