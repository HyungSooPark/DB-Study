package com.dao;

import java.sql.Connection;
import java.util.List;

import com.dto.Member;

public interface MemberDao {
	public String selectAll = "SELECT * FROM TB_MEMBER";
	public String selectOne = "SELECT * FROM TB_MEMBER WHERE M_NO=?";
	public String insert = "INSERT INTO TB_MEMBER VALUES(MEMBERSQ.NEXTVAL,?,?,?,?,?,?,?)";
	public String delete = "DELETE FROM TB_MEMBER WHERE M_NO=?";
	public String update = "UPDATE TB_MEMBER SET M_NAME=?,M_AGE=?,M_GENDER=?,M_LOCATION=?,M_JOB=?,M_TELL=?,M_EMAIL=? WHERE M_NO=?";
	
	public List<Member> selectAll(Connection con);
	public Member selectOne(Connection con,int no);
	public int insert(Connection con, Member m);
	public int delete(Connection con,int no);
	public int update(Connection con,Member m);
}
