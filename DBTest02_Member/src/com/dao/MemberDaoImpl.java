package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static common.JDBCTemplate.*;
import com.dto.Member;

public class MemberDaoImpl implements MemberDao {

	@Override
	public List<Member> selectAll(Connection con) {
		Statement stmt = null;
		ResultSet rs = null;
		List<Member> res = new ArrayList<>();

		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(selectAll);

			while (rs.next()) {
				Member tmp = new Member();
				tmp.setM_no(rs.getInt(1));
				tmp.setM_name(rs.getString(2));
				tmp.setM_age(rs.getInt(3));
				tmp.setM_gender(rs.getString("M_GENDER"));
				tmp.setM_location(rs.getString(5));
				tmp.setM_job(rs.getString(6));
				tmp.setM_tell(rs.getString(7));
				tmp.setM_email(rs.getString(8));
				res.add(tmp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(stmt);
		}

		return res;
	}

	@Override
	public Member selectOne(Connection con, int no) {
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Member resOne = new Member();

		try {
			pstm = con.prepareStatement(selectOne);
			pstm.setInt(1, no);
			rs = pstm.executeQuery();

			while (rs.next()) {
				resOne.setM_no(rs.getInt(1));
				resOne.setM_name(rs.getString(2));
				resOne.setM_age(rs.getInt(3));
				resOne.setM_gender(rs.getString("M_GENDER"));
				resOne.setM_location(rs.getString(5));
				resOne.setM_job(rs.getString(6));
				resOne.setM_tell(rs.getString(7));
				resOne.setM_email(rs.getString(8)); 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstm);
		}

		return resOne;
	}

	@Override
	public int insert(Connection con, Member m) {
		PreparedStatement pstm = null;
		int res = 0;

		try {
			pstm = con.prepareStatement(insert);
			pstm.setString(1, m.getM_name());
			pstm.setInt(2, m.getM_age());
			pstm.setString(3, m.getM_gender());
			pstm.setString(4, m.getM_location());
			pstm.setString(5, m.getM_job());
			pstm.setString(6, m.getM_tell());
			pstm.setString(7, m.getM_email());
			
			res = pstm.executeUpdate();
			
			if(res>0) commit(con);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstm);
		}

		return res;
	}

	@Override
	public int delete(Connection con, int no) {
		PreparedStatement pstm = null;
		int res = 0;
		
		try {
			pstm = con.prepareStatement(delete);
			pstm.setInt(1, no);
			res = pstm.executeUpdate();
			
			if(res>0) commit(con);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstm);
		}
		
		return res;
	}

	@Override
	public int update(Connection con, Member m) {
		PreparedStatement pstm = null;
		int res = 0;

		try {
			pstm = con.prepareStatement(update);
			pstm.setString(1, m.getM_name());
			pstm.setInt(2, m.getM_age());
			pstm.setString(3, m.getM_gender());
			pstm.setString(4, m.getM_location());
			pstm.setString(5, m.getM_job());
			pstm.setString(6, m.getM_tell());
			pstm.setString(7, m.getM_email());
			pstm.setInt(8, m.getM_no());
			
			res = pstm.executeUpdate();
			
			if(res>0) commit(con);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstm);
		}

		return res;
	}

}
