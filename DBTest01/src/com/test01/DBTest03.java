package com.test01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class DBTest03 {
	//insert
	public static void main(String[] args) throws Exception {
		//준비
		Connection con = null;
		Statement stmt = null;
		//ResultSet x
		int res = 0;
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String id = "KH";
		String pw = "KH";
		
		//입력
		int no=0;
		String name = null;
		String nickname = null;
		Scanner sc = new Scanner(System.in);
		
		System.out.print("번호 입력: ");
		no = sc.nextInt();
		System.out.print("이름 입력: ");
		name = sc.next();
		System.out.print("별명 입력: ");
		nickname = sc.next();
	
		String sql = "INSERT INTO MYTEST VALUES("+no+",'"+name+"','"+nickname+"')";
		//System.out.println(sql);
		
		//드라이버 등록
		Class.forName(driver);
		//연결
		con = DriverManager.getConnection(url,id,pw);
		//실행 및 결과 처리
		stmt = con.createStatement();
		res = stmt.executeUpdate(sql);
		
		if(res>0) {
			System.out.println("insert 성공");
		}
		else {
			System.out.println("insert 실패");
		}
		
		//종료
		stmt.close();
		con.close();
		sc.close();
	}

}
