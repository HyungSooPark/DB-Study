package com.biz;

import java.util.List;

import com.dto.Member;


public interface MemberBiz {
	public List<Member> selectAll();
	public Member selectOne(int no);
	public int insert(Member m);
	public int delete(int no);
	public int update(Member m);
}
