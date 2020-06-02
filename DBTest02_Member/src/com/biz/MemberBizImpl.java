package com.biz;

import java.sql.Connection;
import java.util.List;

import com.dao.MemberDaoImpl;
import com.dto.Member;

import static common.JDBCTemplate.*;

public class MemberBizImpl implements MemberBiz{
	MemberDaoImpl dao = new MemberDaoImpl();
	
	@Override
	public List<Member> selectAll() {
		Connection con = getConnection();
		List<Member> res = dao.selectAll(con);
		close(con);
		return res;
	}

	@Override
	public Member selectOne(int no) {
		Connection con = getConnection();
		Member resOne = dao.selectOne(con, no);
		close(con);
		return resOne;
	}

	@Override
	public int insert(Member m) {
		Connection con = getConnection();
		int res = dao.insert(con, m);
		close(con);
		return res;
	}

	@Override
	public int delete(int no) {
		Connection con = getConnection();
		int res = dao.delete(con, no);
		close(con);
		return res;
	}

	@Override
	public int update(Member m) {
		Connection con = getConnection();
		int res = dao.update(con, m);
		close(con);
		return res;
	}

}
