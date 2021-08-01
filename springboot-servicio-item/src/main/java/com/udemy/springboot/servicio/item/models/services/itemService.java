package com.udemy.springboot.servicio.item.models.services;

import java.util.List;

import com.udemy.springboot.servicio.item.models.Item;

public interface itemService {

	public List<Item> findAll();
	public Item findById(Long id,Integer cantidad);
}
