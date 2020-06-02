package product.controller;

import java.util.List;

import product.model.service.ProductService;
import product.model.vo.Product;

public class ProductController {
	ProductService ps = new ProductService();
	
	public List<Product> selectAll() {
		return ps.selectAll();
	}

	public void insert(Product p) {
		ps.insert(p);
	}

	public void delete(String id) {
		ps.delete(id);
	}

	public void update(Product p) {
		ps.update(p);
	}

	public Product selectOne(String id) {
		return ps.selectOne(id);
	}

}
