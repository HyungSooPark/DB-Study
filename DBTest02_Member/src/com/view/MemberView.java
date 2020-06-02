package com.view;

import java.util.List;
import java.util.Scanner;

import com.biz.MemberBizImpl;
import com.dto.Member;

public class MemberView {
	static Scanner sc = new Scanner(System.in);
	
	public static int getMenu() {
		int select=0;
		
		System.out.println("************");
		System.out.println("1. selectAll");
		System.out.println("2. selectOne");
		System.out.println("3. insert");
		System.out.println("4. update");
		System.out.println("5. delete");
		System.out.println("6. exit");
		System.out.println("************");
		System.out.print("input select: ");
		select = sc.nextInt();
		
		return select;
	}
	
	public static void main(String[] args) {
		int select=0;
		MemberBizImpl memberBiz = new MemberBizImpl();
		
		while(select!=6) {
			select = getMenu();
			
			switch(select) {
			case 1:	//전체 출력
				List<Member> res = memberBiz.selectAll();
				for(Member m : res) {
					System.out.println(m);
				}
				System.out.println();
				break;
			case 2: //선택 출력
				System.out.print("번호 선택: ");
				int no = sc.nextInt();
				Member resOne = memberBiz.selectOne(no);
				System.out.println(resOne);
				System.out.println();
				break;
			case 3:
				System.out.print("이름 입력: ");
				String m_name = sc.next();
				System.out.print("나이 입력: ");
				int m_age = sc.nextInt();
				System.out.print("성별 입력(M/F): ");
				String m_gender = sc.next();
				System.out.print("지역 입력: ");
				String m_location = sc.next();
				System.out.print("직업 입력: ");
				String m_job = sc.next();
				System.out.print("번호 입력: ");
				String m_tell = sc.next();
				System.out.print("이메일 입력: ");
				String m_email = sc.next();
				
				Member m = new Member(0,m_name,m_age,m_gender,m_location,m_job,m_tell,m_email);
				
				int insertRes = memberBiz.insert(m);
				
				if(insertRes>0) {
					System.out.println("insert 성공");
				}
				else {
					System.out.println("insert 실패");
				}
				System.out.println();
				break;
			case 4:
				System.out.print("번호 입력: ");
				int u_no = sc.nextInt();
				System.out.print("이름 입력: ");
				String u_name = sc.next();
				System.out.print("나이 입력: ");
				int u_age = sc.nextInt();
				System.out.print("성별 입력(M/F): ");
				String u_gender = sc.next();
				System.out.print("지역 입력: ");
				String u_location = sc.next();
				System.out.print("직업 입력: ");
				String u_job = sc.next();
				System.out.print("번호 입력: ");
				String u_tell = sc.next();
				System.out.print("이메일 입력: ");
				String u_email = sc.next();
				
				Member m2 = new Member(u_no,u_name,u_age,u_gender,u_location,u_job,u_tell,u_email);
				
				int updateRes = memberBiz.insert(m2);
				
				if(updateRes>0) {
					System.out.println("update 성공");
				}
				else {
					System.out.println("update 실패");
				}
				System.out.println();
				break;
			case 5:
				System.out.print("번호 선택: ");
				int delete_no = sc.nextInt();
				
				int deleteRes = memberBiz.delete(delete_no);
				
				if(deleteRes>0) {
					System.out.println("delete 성공");
				}
				else {
					System.out.println("delete 실패");
				}
				System.out.println();
				break;
			case 6:
			default:
				System.out.println("--- wrong input ---\n");
				break;
			}
		}
	}
	
}
