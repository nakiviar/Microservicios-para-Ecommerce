package com.udemy.springboot.servicio.item.models.services;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.udemy.springboot.servicio.item.models.Item;
import com.udemy.springboot.servicio.item.models.Producto;

@Service
public class ItemServiceImpl implements itemService {
	
	@Autowired
	private RestTemplate clienteRest;
	

	@Override
	public List<Item> findAll() {
		//clienteRest.getForObject("", Producto[].class); devuelve un arreglo, sin embargo lo convertimos en lista con Arrays.asList
		List<Producto> listaProductos = Arrays.asList(clienteRest.getForObject("http://localhost:8001/listar", Producto[].class));
		return listaProductos.stream().map(p ->  new Item(p, 1)).collect(Collectors.toList());
	}

	@Override
	public Item findById(Long id, Integer cantidad) {
		Map<String, String> pathVariables = new HashMap<String, String>();
		pathVariables.put("id", id.toString());
		Producto producto=clienteRest.getForObject("http://localhost:8001/ver/{id}", Producto.class,pathVariables);
		return new Item(producto,cantidad);
	}

}
