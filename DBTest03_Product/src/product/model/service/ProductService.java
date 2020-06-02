package product.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import product.model.dao.ProductDao;
import product.model.vo.Product;

import static common.JDBCTemplate.*;

public class ProductService {

	public List<Product> selectAll() {
		ProductDao dao = new ProductDao();
		Connection con = getConnection();
		
		ArrayList<Product> res = dao.selectAll(con);
		close(con);
		return res;
	}

	public void insert(Product p) {
		ProductDao dao = new ProductDao();
		Connection con = getConnection();
		dao.insert(con, p);
		close(con);
	}

	public void delete(String id) {
		ProductDao dao = new ProductDao();
		Connection con = getConnection();
		dao.delete(con,id);
		close(con);
	}

	public void update(Product p) {
		ProductDao dao = new ProductDao();
		Connection con = getConnection();
		dao.update(con,p);
		close(con);
	}

	public Product selectOne(String id) {
		ProductDao dao = new ProductDao();
		Connection con = getConnection();
		Product res = dao.selectOne(con,id);
		close(con);
		return res;
	}

}
