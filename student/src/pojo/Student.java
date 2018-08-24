package pojo;

import org.omg.CORBA.PUBLIC_MEMBER;

public class Student {
	
	private int sid;
	private String sno;
	private String sname;
	private String ssex;
	private int sage;
	private String saddress;
	
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSsex() {
		return ssex;
	}
	public void setSsex(String ssex) {
		this.ssex = ssex;
	}
	public int getSage() {
		return sage;
	}
	public void setSage(int sage) {
		this.sage = sage;
	}
	public String getSaddress() {
		return saddress;
	}
	public void setSaddress(String saddress) {
		this.saddress = saddress;
	}
	public void setStudent(Student student) {
		this.sno = student.getSno();
		this.sage = student.getSage();
		this.ssex = student.getSsex();
		this.sname = student.getSname();
		this.saddress = student.getSaddress();
		
	}
}
