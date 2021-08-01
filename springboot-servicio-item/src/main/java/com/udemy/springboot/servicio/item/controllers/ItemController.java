package com.udemy.springboot.servicio.item.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.springboot.servicio.item.models.Item;
import com.udemy.springboot.servicio.item.models.services.itemService;

@RestController
public class ItemController {
	
	@Autowired
	@Qualifier("serviceFeign")
	private itemService itemservice;
	
	@GetMapping("/listar")
	public List<Item> listar(){
		return itemservice.findAll();
	}
	
	@GetMapping("/ver/{id}/cantidad/{cantidad}")
	public Item detalleItem(@PathVariable Long id, @PathVariable Integer cantidad) {
		return itemservice.findById(id, cantidad);
	}

}
