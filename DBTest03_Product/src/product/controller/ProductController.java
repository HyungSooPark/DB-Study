package product.controller;

import java.util.List;

import product.model.service.ProductService;
import product.model.vo.Product;

public class ProductController {
	ProductService ps = new ProductService();
	
	public List<Product> selectAll() {
		return ps.selectAll();
	}

	public int insert(Product p) {
		return ps.insert(p);
	}

	public int delete(String id) {
		return ps.delete(id);
	}

	public int update(Product p) {
		return ps.update(p);
	}

	public Product selectOne(String id) {
		return ps.selectOne(id);
	}

}
