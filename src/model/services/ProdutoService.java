package model.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.entities.Produto;

public class ProdutoService {

	public List<Produto> findAll() {
		List<Produto> list = new ArrayList<>();
		list.add(new Produto(1, "Parafuso", "Serve para parafusar", 0.50, 200, new Date()));
		list.add(new Produto(2, "Cachorro-quente", "Pão com salsicha", 5.50, 15, new Date()));
		list.add(new Produto(3, "Pastel de carne", "Carne moída com azeitona picada", 4.50, 50, new Date()));

		return list;
	}
}
