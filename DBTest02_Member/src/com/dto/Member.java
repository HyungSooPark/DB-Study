package com.dto;

public class Member {
	private int m_no;
	private String m_name;
	private int m_age;
	private String m_gender;
	private String m_location;
	private String m_job;
	private String m_tell;
	private String m_email;
	
	public Member() {
		super();
		
	}

	public Member(int m_no, String m_name, int m_age, String m_gender, String m_location, String m_job, String m_tell,
			String m_email) {
		super();
		this.m_no = m_no;
		this.m_name = m_name;
		this.m_age = m_age;
		this.m_gender = m_gender;
		this.m_location = m_location;
		this.m_job = m_job;
		this.m_tell = m_tell;
		this.m_email = m_email;
	}
	
	public int getM_no() {
		return m_no;
	}

	public void setM_no(int m_no) {
		this.m_no = m_no;
	}

	public String getM_name() {
		return m_name;
	}

	public void setM_name(String m_name) {
		this.m_name = m_name;
	}

	public int getM_age() {
		return m_age;
	}

	public void setM_age(int m_age) {
		this.m_age = m_age;
	}

	public String getM_gender() {
		return m_gender;
	}

	public void setM_gender(String m_gender) {
		this.m_gender = m_gender;
	}

	public String getM_location() {
		return m_location;
	}

	public void setM_location(String m_location) {
		this.m_location = m_location;
	}

	public String getM_job() {
		return m_job;
	}

	public void setM_job(String m_job) {
		this.m_job = m_job;
	}

	public String getM_tell() {
		return m_tell;
	}

	public void setM_tell(String m_tell) {
		this.m_tell = m_tell;
	}

	public String getM_email() {
		return m_email;
	}

	public void setM_email(String m_email) {
		this.m_email = m_email;
	}

	@Override
	public String toString() {
		return "Member [m_no=" + m_no + ", m_name=" + m_name + ", m_age=" + m_age + ", m_gender=" + m_gender
				+ ", m_location=" + m_location + ", m_job=" + m_job + ", m_tell=" + m_tell + ", m_email=" + m_email
				+ "]";
	}
	
	
}
