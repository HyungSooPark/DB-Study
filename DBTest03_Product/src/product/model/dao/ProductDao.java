package product.model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import product.model.vo.Product;

import static common.JDBCTemplate.*;

public class ProductDao {
	private Properties prop;
	
	public ProductDao() {
		prop = new Properties();
		try {
			prop.load(new FileReader("query.properties"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Product> selectAll(Connection con) {
		PreparedStatement pstm = null;
		ResultSet rs = null;
		ArrayList<Product> list = null;
		String sql = prop.getProperty("selectAll");
		
		try {
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			list = new ArrayList<Product>();
			
			while(rs.next()) {
//				Product p = new Product(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getString(4));
				Product p = new Product();
				p.setpId(rs.getString(1));
				p.setpName(rs.getString(2));
				p.setPrice(rs.getInt(3));
				p.setDesc(rs.getString(4));
				
				list.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstm);
		}
		
		return list;
	}

	public void insert(Connection con, Product p) {
		PreparedStatement pstm = null;
		int res = 0;
		String sql = prop.getProperty("insert");
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, p.getpId());
			pstm.setString(2, p.getpName());
			pstm.setInt(3, p.getPrice());
			pstm.setString(4, p.getDesc());
			
			res = pstm.executeUpdate();
			
			if(res>0) {
				System.out.println("추가 성공");
				commit(con);
			}
			else {
				System.out.println("추가 실패");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstm);
		}
	}

	public void delete(Connection con, String id) {
		PreparedStatement pstm = null;
		int res = 0;
		String sql = prop.getProperty("delete");
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, id);
			res = pstm.executeUpdate();
			
			if(res>0) {
				System.out.println("삭제 성공");
				commit(con);
			}
			else {
				System.out.println("삭제 실패");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstm);
		}
	}

	public void update(Connection con, Product p) {
		PreparedStatement pstm = null;
		int res = 0;
		String sql = prop.getProperty("update");
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, p.getpName());
			pstm.setInt(2, p.getPrice());
			pstm.setString(3, p.getDesc());
			pstm.setString(4, p.getpId());
			
			res = pstm.executeUpdate();
			
			if(res>0) {
				System.out.println("수정 성공");
				commit(con);
			}
			else {
				System.out.println("수정 실패");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstm);
		}
	}

	public Product selectOne(Connection con,String id) {
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String sql = prop.getProperty("selectOne");
		
		Product res = null;
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, id);
			
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				res = new Product(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstm);
		}
		return res;
	}

}
